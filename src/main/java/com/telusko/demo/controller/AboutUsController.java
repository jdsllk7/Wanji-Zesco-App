package com.telusko.demo.controller;

import com.telusko.demo.model.User;
import com.telusko.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AboutUsController {

    private final UserService userService;

    @Autowired
    public AboutUsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("aboutUs")
    public String aboutUs(Model model, HttpServletRequest request) {

        User user = userService.userSession(request);
        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("user", user);

        return "aboutUs";
    }

}
