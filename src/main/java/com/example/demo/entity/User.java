package com.example.demo.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private Date createTs;

    private Date updateTs;

    private String username;

    private String password;
}