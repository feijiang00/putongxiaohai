package com.xiaojiang.putongxiaohai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author: XiaoJiang
 * @Date: 2021/05/05/1:51
 * @QQ群: 807092830
 * @Description: 自定义异常
 */

/**
 * 继承RuntimeException，实现继承RuntimeException的构造函数
 * @ResponseStatus(HttpStatus.NOT_FOUND) 注解表示资源找不到的状态码，标识了状态码的时候就不拦截
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}