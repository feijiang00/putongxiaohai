package com.xiaojiang.putongxiaohai.web.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: XiaoJiang
 * @Date: 2021/04/26/2:02
 * @QQ群: 807092830
 * @Description:
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String getIndex(){

        return "index";
    }
}