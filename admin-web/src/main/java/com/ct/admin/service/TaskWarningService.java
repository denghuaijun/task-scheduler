package com.ct.admin.service;

import com.ct.admin.dao.entity.TaskWarningManager;
import com.ct.admin.dao.entity.TaskWarningManagerExample;
import com.ct.admin.dao.mapper.TaskWarningManagerMapper;
import com.ct.admin.model.TaskWarningDTO;
import com.ct.admin.utils.BeanConvertUtils;
import com.ct.core.model.ReturnDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service
public class TaskWarningService {

    @Resource
    private TaskWarningManagerMapper taskWarningManagerMapper;

    /**
     *添加告警信息
     * @param taskWarningDTO
     * @return
     */
    @Transactional
    public ReturnDTO<String> taskwarningAdd(TaskWarningDTO taskWarningDTO) {
        TaskWarningManager taskWarningManager = new TaskWarningManager();
        try{
            BeanConvertUtils.copyProperties(taskWarningDTO,taskWarningManager);
            taskWarningManager.setCreateTime(new Date());
            int i = taskWarningManagerMapper.insertSelective(taskWarningManager);
            if (i>0){
                return ReturnDTO.SUCCESS();
            }
        }catch (Exception e){
            log.error(e.getMessage(), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "添加告警用户失败:" + e.getMessage());
        }
        return ReturnDTO.FAIL();
    }
    /**
     * 分页
     * @param start
     * @param length
     * @return
     */

    public Map<String, Object> pageList(int start,int length) {

        TaskWarningManagerExample example = new TaskWarningManagerExample();
        example.setOrderByClause(" create_time desc");
        Page<Object> objects = PageHelper.offsetPage(start, length);

        // page list
        List<TaskWarningManager> taskWarningManagerList = taskWarningManagerMapper.selectByExample(example);
        List<TaskWarningDTO> taskWarningDTOList = new ArrayList();
        if (!taskWarningManagerList.isEmpty()) {
           BeanConvertUtils.copyPropertieses(taskWarningManagerList,taskWarningDTOList,TaskWarningDTO.class);
        }

        //查询调度状态

        // package result
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("recordsTotal", objects.getTotal());        // 总记录数
        maps.put("recordsFiltered", objects.getTotal());    // 过滤后的总记录数
        maps.put("data", taskWarningDTOList);                    // 分页列表
        return maps;
    }

    /**
     * 初始化查询所有告警信息下拉列表
     * @return
     */
    public List<TaskWarningManager> selectTaskWarnningList() {
        TaskWarningManagerExample example = new TaskWarningManagerExample();
        example.setOrderByClause("create_time desc");
        List<TaskWarningManager> taskWarningManagerList = taskWarningManagerMapper.selectByExample(example);
        return taskWarningManagerList;
    }

    /**
     * 根据主键查询告警信息
     * @param id
     * @return
     */
    public TaskWarningManager findTaskWarning(long id) {

        return taskWarningManagerMapper.selectByPrimaryKey(id);
    }
}
