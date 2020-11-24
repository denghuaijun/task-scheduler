package wang.niceu.task.simple.util.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 供应商接口代码枚举类
 */

public enum VendorServiceContractCodeEnum {


        HEJIN("hj","hj1","合金"), //合金福建 ------社保数据
        HUIZHISHU("hzs","hzs1", "慧智数"), //贵州 ------社保数据
        HAIDEBJ("hd", "hd1","海德"), //海德北京 ------社保数据
        GROUPSLYK("groupslyk","slyk1", "集团数联易康"), //四川 ------社保数据
        GROUPLY("grouply","ly1", "集团乐约"), //河南 ------社保数据
        HAIDEFUJIAN("haidefujian","hd1", "海德福建"); //海德福建 ------社保数据

        private String serviceCode;
        private String contractCode;
        private String contractName;

    VendorServiceContractCodeEnum(String serviceCode, String contractCode, String contractName) {
        this.serviceCode = serviceCode;
        this.contractCode = contractCode;
        this.contractName = contractName;
    }

    /**
     * 根据接口代码获取对应的合同编码
     * @param serviceCode
     * @return
     */
    public static String getContractCodeByServiceCode(String serviceCode){
        for (VendorServiceContractCodeEnum codeEnum : VendorServiceContractCodeEnum.values()){
            if (codeEnum.getServiceCode().equals(serviceCode)){
                return codeEnum.getContractCode();
            }
        }
        return "";
    }
    /**
     * 根据接口代码获取对应的合同编码
     * @param contractCode
     * @return
     */
    public static List<String> getServiceCodeByContractCode(String contractCode){
        List<String> list = new ArrayList<>();
        for (VendorServiceContractCodeEnum codeEnum : VendorServiceContractCodeEnum.values()){
            if (codeEnum.getContractCode().equals(contractCode)){
                list.add(codeEnum.getServiceCode());
            }
        }
        return list;
    }





    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }}
