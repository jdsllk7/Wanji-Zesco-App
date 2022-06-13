package com.telusko.demo.controller;

import com.telusko.demo.model.User;
import com.telusko.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("login")
    public String login(ModelMap modelMap) {
        User user = userService.getUserByEmailAndPassword("abc@gmail.com", "12345");
        modelMap.addAttribute("user", user);
        return "login";
    }

    @PostMapping(value = {"login"})
    @ResponseBody
    public Map<String, Object> login(MultipartHttpServletRequest map) {
        return userService.validateUser(map);
    }

}
