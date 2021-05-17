package com.xiaojiang.putongxiaohai.model.dto;

import com.xiaojiang.putongxiaohai.model.domain.Article;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: XiaoJiang
 * @Date: 2021/05/02/14:25
 * @QQ群: 807092830
 * @Description:
 */
@Getter
@Setter
public class ArchiveBo implements Serializable {

    private static final long serialVersionUID = 6766184592631951371L;

    private String date;
    private List<Article> articles;

}
