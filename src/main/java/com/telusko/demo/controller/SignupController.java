package com.telusko.demo.controller;

import com.telusko.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

@Controller
public class SignupController {

    private final UserService userService;

    @Autowired
    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("signup")
    public String signup() {
        return "signup";
    }

    @PostMapping(value = {"signup"})
    @ResponseBody
    public Map<String, Object> signup(MultipartHttpServletRequest map) {
        return userService.signup(map);
    }

}
