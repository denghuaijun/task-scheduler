package springconfig;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by libin on 2017/8/20.
 */

@Configuration
@MapperScan( basePackages = {"com.ct.admin.dao.mapper"})
public class MybatisConfiguration {

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("dialect", "mysql");
        properties.setProperty("pageSizeZero", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }


}
