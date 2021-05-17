package com.xiaojiang.putongxiaohai.hander;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: XiaoJiang
 * @Date: 2021/05/03/22:52
 * @QQ群: 807092830
 * @Description: 拦截异常处理
 */
@Slf4j
//@ControllerAdvice表示拦截掉所有带有@Controller注解的控制器
@ControllerAdvice //这是一共增强的Controller，使用这个Controller可以实现以下：1.全局异常处理2.全局数据绑定3.全局数据预处理
public class ControllerExceptionHandler {

    //    将异常记录到日志
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHander(HttpServletRequest request, Exception e) throws Exception {

//        记录异常信息：请求的URL，异常信息
        log.error("Requst URL : {}，Exception : {}", request.getRequestURL(),e);

//        当标识了状态码的时候就不拦截
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }

//        将记录的异常信息返回到error页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception", e);
        mv.setViewName("error/error");
        return mv;
    }
}
