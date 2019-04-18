package com.jhy.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;

    private String userName;

    private String userPassword;

    private String userEmail;

    private Date createTime;

    private String userInfo;

    private byte[] headImg;

}