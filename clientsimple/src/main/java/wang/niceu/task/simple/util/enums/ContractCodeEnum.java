package wang.niceu.task.simple.util.enums;

/**
 * 合同规则对应编码及厂商名称枚举类
 */
public enum ContractCodeEnum {

    LY("ly1","乐约"),
    HZS("hzs1","贵州慧智树"),
    SLYK("slyk1","成都数联易康"),
    HD("hd1","海德"),
    HJ("hj1","合金在线")

    ;


    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ContractCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
    /**
     *根据合同编码获取对应的合同厂商名称
     */
    public static String getContractNameByCode(String code){
        for (ContractCodeEnum contractCodeEnum: ContractCodeEnum.values()){
            if (contractCodeEnum.getCode().equals(code)){
                return contractCodeEnum.getName();
            }
        }
        return "";
    }
}
