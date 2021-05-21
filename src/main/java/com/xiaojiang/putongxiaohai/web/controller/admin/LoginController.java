package com.xiaojiang.putongxiaohai.web.controller.admin;

import com.xiaojiang.putongxiaohai.model.domain.User;
import com.xiaojiang.putongxiaohai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @Author: XiaoJiang
 * @Date: 2021/05/05/2:42
 * @QQ群: 807092830
 * @Description: 用户登录控制器
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;


    @GetMapping
    public String loginPage(){
        return "admin/part/admin_login";
    }



    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String userPwd,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.checkUser(username, userPwd);
        if (user != null) {
            user.setUserPwd(null);
            session.setAttribute("user",user);
            return "admin/part/admin_index";
        } else {
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}

/**
 * 登录校验：将前端传递过来的用户名和密码给service进行检验核对，并放入session域中（session是全局的，登录后访问其他页面或者重开页面也是登录状态）
 * 登录成功跳转后台管理页面，失败则跳转登录页面
 * 登录成功后可以进行注销，注销后返回登录页面
 */
