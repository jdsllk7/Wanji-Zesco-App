package com.telusko.demo.controller;

import com.telusko.demo.model.Equipment;
import com.telusko.demo.model.User;
import com.telusko.demo.service.EquipmentService;
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
public class EquipmentController {

    private final UserService userService;
    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(UserService userService, EquipmentService equipmentService) {
        this.userService = userService;
        this.equipmentService = equipmentService;
    }


    @GetMapping("equipment")
    public String get(Model model, HttpServletRequest request) {

        List<Equipment> equipment = equipmentService.getAllEquipment();
        User user = userService.userSession(request);
        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("user", user);
        model.addAttribute("equipment", equipment);
        return "equipment";
    }

    @PostMapping(value = {"equipment"})
    @ResponseBody
    public Map<String, Object> post(HttpServletRequest request) {
        return equipmentService.save(request);
    }

}
