package com.oldou.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 日志切面处理
 *
 */
@Aspect
@Component
public class LogAspect {
    //日志记录
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //切点  所有控制器都会被定义成切点
    @Pointcut("execution(* com.oldou.controller.*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        logger.info("Request : {}", requestLog);
    }

    @After("log()")
    public void doAfter(){
        //logger.info("----------------doAfter()------------------");
    }

    /*
    2022-01-13 11:24:22.990  INFO 10860 --- [nio-8081-exec-9] com.oldou.aspect.LogAspect               : Request : RequestLog{url='http://localhost:8081/about', ip='0:0:0:0:0:0:0:1', classMethod='com.oldou.controller.AboutShowController.about', args=[]}
    2022-01-13 11:24:22.990  INFO 10860 --- [nio-8081-exec-9] com.oldou.aspect.LogAspect               : Result : about
     */
    //方法请求完返回之后去拦截
    //这里因为方法返回的是页面，也就是String字符串，因此显示的是字符串
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result : {}",result);
    }


    public class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
/**
 * @Aspect注解：AOP切面作用
 * @Component注解：开启组件扫描，通过注解找到要扫描的对象
 * @Pointcut("execution(* com.star.controller..(..))")：定义切面，申明log()是一个切面，通过execution来表示需要拦截的类，这里表示拦截控制器下面的所有类所有方法
 * RequestLog：将请求的参数封装成一个内部类
 * 在访问页面（controller）之前，拦截请求的URL、IP、调用的方法、传递的参数、返回的内容，并记录到日志
 */
