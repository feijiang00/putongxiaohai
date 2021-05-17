package com.xiaojiang.putongxiaohai.model.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: XiaoJiang
 * @Date: 2021/04/29/20:49
 * @QQ群: 807092830
 * @Description: 友链实体类
 */
@Data
public class Friend {
    private Integer id;

    private String blogAddress;

    private String blogName;

    private Date createTime;

    private String pictureAddress;

}
