package com.ct.admin.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUserDTO implements Serializable {

    private String loginUserName;

    private String loginPassWord;

    private String ifRemember;
}
