package com.xiaojiang.putongxiaohai.model.domain;

import lombok.Data;

/**
 * @Author: XiaoJiang
 * @Date: 2021/04/29/21:02
 * @QQ群: 807092830
 * @Description: 图床实体类
 */
@Data
public class Picture {
    private Integer id;

    private String pictureAddress;

    private String pictureDescription;

    private String pictureName;

    private String pictureTime;
}
