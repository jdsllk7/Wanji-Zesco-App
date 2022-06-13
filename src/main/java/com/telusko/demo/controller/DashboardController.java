package com.telusko.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @GetMapping("dashboard")
    public String dashboard(Model model, HttpSession session) {
        String firstName = (String) session.getAttribute("sessionFirstName");
        model.addAttribute("firstName", firstName);
        return "dashboard";
    }

}
