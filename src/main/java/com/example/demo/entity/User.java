package com.example.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class User {
    private Integer id;

    private Date createTs;

    private Date updateTs;

    @NotEmpty(message = "用户名不能为空")
    private String username;

    private String password;
}