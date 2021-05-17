package com.xiaojiang.putongxiaohai.service;

import com.xiaojiang.putongxiaohai.model.domain.User;

/**
 * @Author: XiaoJiang
 * @Date: 2021/05/05/2:35
 * @QQ群: 807092830
 * @Description: 用户业务层接口
 */
public interface UserService {
    //核对用户名和密码
    User checkUser(String username, String password);
}

