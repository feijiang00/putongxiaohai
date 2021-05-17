package com.xiaojiang.putongxiaohai.model.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: XiaoJiang
 * @Date: 2021/04/29/20:58
 * @QQ群: 807092830
 * @Description:留言实体类
 */
@Data
public class Message {
    private Integer id;

    private String nickname;

    private String email;

    private String content;

    private String avatar;

    private Date createTime;

    private  Long parentMessageId;

    private Integer adminMessage;

}
