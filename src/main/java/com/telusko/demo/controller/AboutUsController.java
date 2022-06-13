package com.telusko.demo.controller;

import com.telusko.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {

    @Autowired
    public AboutUsController(UserService userService) {
    }

    @GetMapping("aboutUs")
    public String aboutUs() {
        return "aboutUs";
    }

}
