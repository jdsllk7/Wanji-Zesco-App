package com.telusko.demo.controller;

import com.telusko.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping(value = {"login"})
    @ResponseBody
    public Map<String, Object> login(MultipartHttpServletRequest map) {
        return userService.validateUser(map);
    }

    @GetMapping(value = {"logout"})
    @ResponseBody
    public Map<String, Object> logout(MultipartHttpServletRequest map) {
        return userService.logout(map);
    }

}
