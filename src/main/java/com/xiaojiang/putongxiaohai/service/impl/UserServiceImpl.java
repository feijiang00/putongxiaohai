package com.xiaojiang.putongxiaohai.service.impl;

import com.xiaojiang.putongxiaohai.dao.UserDao;
import com.xiaojiang.putongxiaohai.model.domain.User;
import com.xiaojiang.putongxiaohai.service.UserService;
import com.xiaojiang.putongxiaohai.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: XiaoJiang
 * @Date: 2021/05/05/2:38
 * @QQ群: 807092830
 * @Description: 用户业务层接口实现类,这里主要是获取数据库中的用户名和密码，通过控制器传递过来的密码进行解析匹配，匹配成功则登录
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
