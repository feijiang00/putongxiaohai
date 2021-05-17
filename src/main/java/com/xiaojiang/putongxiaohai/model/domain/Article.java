package com.xiaojiang.putongxiaohai.model.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: XiaoJiang
 * @Date: 2021/04/29/13:16
 * @QQ群: 807092830
 * @Description: 文章实体类
 */

@Data
public class Article {
    /**
     * int 对应 Integer
     * bigint 对应 Long
     * varchar,longtext 对应 String
     * datetime 对应 Date
     * bit  对应  boolean
     */
    private Integer id;

    private Integer userId;

    private String articleTitle;//文章标题

    private String articleContent;//文章内容

    private String articleSummary;//文章摘要

    private int articleFlag;//文章标志

    private int articleStatus;//文章状态

    private String first_picture;

    private boolean appreciation;//赞赏

    private boolean share_statement;//转载声明

    private boolean commentabled;//评论开启

    private boolean recommend;//推荐置顶开启

    private Date createTime;//创建时间

    private Date updateTime;//最后更新时间

    private Integer type_id;//文章分类id

    private Integer tag_id;//文章标签id

    private Integer commentCount;//文章评论数量

    private  Long views;//文章访问量


}
