package com.example.demo.view.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by xxf on 2018/12/2 0002.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReq {
    private String username;
    private Integer pageNo;
    private Integer pageSize;
}
