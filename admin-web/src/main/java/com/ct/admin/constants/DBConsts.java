package com.ct.admin.constants;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 23:04 2018/10/8
 * @ Description：数据库常量
 * @ Modified By：
 * @Version:
 */
public class DBConsts {

    /**
     * task 任务表
     */
    public static class TaskConst {

        /**
         * 状态
         */
        public enum Status {
            正常(1, "已发布"),
            暂停(2, "编辑中");

            public int value;
            public String desc;

            Status(int value, String desc) {
                this.value = value;
                this.desc = desc;
            }

            public static String getDescByValue(Integer value) {
                String desc = "";
                if (value != null) {
                    for (Status operateType : values()) {
                        if (operateType.value == value) {
                            desc = operateType.desc;
                            break;
                        }
                    }
                }
                return desc;
            }
        }
    }
}
