package com.xiaojiang.putongxiaohai.model.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: XiaoJiang
 * @Date: 2021/04/29/20:51
 * @QQ群: 807092830
 * @Description: 日志实体类
 */
@Data
public class Logs {
    private Integer logId;

    private String logTitle;

    private String logContent;

    private String logIp;

    private Date logDate;
}
