package com.telusko.demo.controller;

import com.telusko.demo.model.Issue;
import com.telusko.demo.model.Equipment;
import com.telusko.demo.model.User;
import com.telusko.demo.service.EquipmentService;
import com.telusko.demo.service.IssueService;
import com.telusko.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class IssueController {

    private final UserService userService;
    private final EquipmentService equipmentService;
    private final IssueService issueService;


    @Autowired
    public IssueController(UserService userService, EquipmentService equipmentService, IssueService issueService) {
        this.userService = userService;
        this.equipmentService = equipmentService;
        this.issueService = issueService;
    }


    @GetMapping("issue")
    public String get(Model model, HttpServletRequest request) {

        User user = userService.userSession(request);
        if (user == null) {
            return "redirect:/login";
        }

        List<Equipment> equipment = equipmentService.getAllEquipment();
        List<Issue> issues = issueService.getAllIssues();

        model.addAttribute("user", user);
        model.addAttribute("issues", issues);
        model.addAttribute("equipment", equipment);
        return "issue";
    }

    @PostMapping(value = {"issue"})
    @ResponseBody
    public Map<String, Object> post(HttpServletRequest request) {
        return issueService.save(request);
    }

    @PostMapping(value = {"saveComment"})
    @ResponseBody
    public Map<String, Object> saveComment(HttpServletRequest request) {
        return issueService.saveComment(request);
    }
}
