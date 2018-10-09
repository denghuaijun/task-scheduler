package com.ct.core.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 19:09 2018/9/13
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
@Data
public class ReturnDTO<T> implements Serializable {

    public static final int RETURN_SUCCESS_CODE = 200;

    public static final int RETURN_FAIL_CODE = 500;

    public static final ReturnDTO<String> SUCCESS(){
        return new ReturnDTO<String>(null);
    }

    public static final ReturnDTO<String> FAIL (){
     return new ReturnDTO<String>(RETURN_FAIL_CODE,null);
    }

    private int code;
    private T content;
    private String msg;

    public ReturnDTO(T content) {
        this.code = RETURN_SUCCESS_CODE;
        this.content = content;
    }

    public ReturnDTO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
