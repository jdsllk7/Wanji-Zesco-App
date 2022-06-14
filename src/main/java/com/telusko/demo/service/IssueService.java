package com.telusko.demo.service;

import com.telusko.demo.model.Issue;
import com.telusko.demo.enums.Response;
import com.telusko.demo.model.Equipment;
import com.telusko.demo.model.User;
import com.telusko.demo.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IssueService {

    private final IssueRepository issueRepository;
    private final EquipmentService equipmentService;
    private final UserService userService;

    @Autowired
    public IssueService(IssueRepository issueRepository, EquipmentService equipmentService, UserService userService) {
        this.issueRepository = issueRepository;
        this.equipmentService = equipmentService;
        this.userService = userService;
    }

    @Transactional(rollbackOn = Exception.class)
    public Map<String, Object> save(HttpServletRequest request) {

        Map<String, Object> response = new HashMap<>();

        try {

            String description = request.getParameter("description");
            String equipmentId = request.getParameter("equipmentId");
            String location = request.getParameter("location");

            Equipment equipment = equipmentService.getEquipmentById(Integer.valueOf(equipmentId));

            User user = userService.userSession(request);

            Issue issue = new Issue();
            issue.setEquipment(equipment);
            issue.setDescription(description);
            issue.setLocation(location);
            issue.setUser(user);
            issueRepository.save(issue);

            response.put(Response.STATUS, Response.SUCCESS);

        } catch (Exception e) {
            response.put(Response.STATUS, Response.ERROR);
            response.put(Response.MESSAGE, "An error occurred. Please try again");
            return response;
        }

        return response;

    }


    @Transactional(rollbackOn = Exception.class)
    public Map<String, Object> saveComment(HttpServletRequest request) {

        Map<String, Object> response = new HashMap<>();

        try {

            String issueId = request.getParameter("issueId");
            String comment = request.getParameter("comment");

            Issue issue = getIssueById(Integer.valueOf(issueId));
            issue.setComment(comment);
            issueRepository.save(issue);

            response.put(Response.STATUS, Response.SUCCESS);

        } catch (Exception e) {
            response.put(Response.STATUS, Response.ERROR);
            response.put(Response.MESSAGE, "An error occurred. Please try again");
            return response;
        }

        return response;

    }

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    public Issue getIssueById(Integer id) {
        return issueRepository.findFirstById(id);
    }
}
