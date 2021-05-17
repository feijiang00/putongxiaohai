package com.xiaojiang.putongxiaohai.model.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: XiaoJiang
 * @Date: 2021/04/29/21:12
 * @QQ群: 807092830
 * @Description: 用户实体类
 */
@Data
public class User {
    private Integer id;

    private String nickname;//用户名称

    private String userName;//登录名

    private String userPwd;//登录密码

    private String userExplain;//个性签名

    private String userEmail;//邮箱

    private String userAvatar;//用户头像

    private Integer userType;//用户类型

    private Date createTime;

    private Date updateTime;

    private String loginEnable;//是否禁用登录

    private Integer loginError;//错误次数

    private Date loginLastTime;//最后登录时间
}
