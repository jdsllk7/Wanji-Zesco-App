package com.telusko.demo.service;

import com.telusko.demo.model.User;
import com.telusko.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(rollbackOn = Exception.class)
    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findFirstByEmailAndPassword(email, password);
    }

    public Map<String, Object> validateUser(MultipartHttpServletRequest map) {

        Map<String, Object> response = new HashMap<>();

        try {

            String email = map.getParameter("email");
            String password = map.getParameter("password");


        } catch (Exception e) {
            response.put("error", "An error occurred. Please try again");
            return response;
        }


        return response;
    }
}
