package com.xiaojiang.putongxiaohai.model.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: XiaoJiang
 * @Date: 2021/04/29/20:44
 * @QQ群: 807092830
 * @Description: 评论实体类
 */
@Data
public class Comment {
    private Integer id;

    private String nickname;//评论用户名

    private String email;//评论邮箱

    private String content;//评论内容

    private String avatar;//评论者头像

    private Date createTime;

    private Integer blogId;//评论所属博客id

    private Long parentCommentId;//评论的父级id

    private Integer adminComment;//是否是管理员评论,这里设置成int不是boolean，是如果管理员增加，则可以变成管理员id字段
}
