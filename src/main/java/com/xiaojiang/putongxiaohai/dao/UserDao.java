package com.xiaojiang.putongxiaohai.dao;

import com.xiaojiang.putongxiaohai.model.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: XiaoJiang
 * @Date: 2021/05/02/21:59
 * @QQ群: 807092830
 * @Description: 用户持久层接口
 */
@Mapper
@Repository
public interface UserDao {

    /**
     * 通过登录时输入的用户名和密码返回用户信息
     */
    User findByUsernameAndPassword(String username,String password);

}


/**
 * @Mapper注解：让Mybatis找到对应的mapper，在编译的时候动态生成代理类，实现相应SQL功能
 * @Repository注解：用来声明dao层的bean（这个注解可有可无，可以消去依赖注入的报错信息）【@Mapper和@Repository注解可以参考这篇文章：Mybatis 中的 @Repository 与 @Mapper】
 * @Param注解：将参数传递给SQL
 * 返回一个User对象给service调用并核对用户名和密码
 */
