package com.telusko.demo.service;

import com.telusko.demo.enums.Response;
import com.telusko.demo.model.User;
import com.telusko.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
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
    public User validateUser(HttpServletRequest request) {

        try {

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            return getUserByEmailAndPassword(email, password);

        } catch (Exception e) {
            return null;
        }
    }

    public User getUserByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findFirstByEmailAndPassword(email, password);
    }

    public User userSession(HttpServletRequest request){
        return (User) request.getSession().getAttribute("user");
    }

    @Transactional(rollbackOn = Exception.class)
    public Map<String, Object> signup(MultipartHttpServletRequest map) {

        Map<String, Object> response = new HashMap<>();

        try {

            String firstName = map.getParameter("firstName");
            String lastName = map.getParameter("lastName");
            String email = map.getParameter("email");
            String role = map.getParameter("role");
            String password = map.getParameter("password");

            User user = userRepository.findFirstByEmailAndPassword(email, password);

            if (user != null) {
                response.put(Response.STATUS, Response.ERROR);
                response.put(Response.MESSAGE, "User account already exists. Please try again");
                return response;
            }

            User user1 = new User();
            user1.setEmail(email);
            user1.setFirstName(firstName);
            user1.setLastName(lastName);
            user1.setPassword(password);
            user1.setRole(role);
            userRepository.save(user1);

            response.put(Response.STATUS, Response.SUCCESS);

        } catch (Exception e) {
            response.put(Response.STATUS, Response.ERROR);
            response.put(Response.MESSAGE, "An error occurred. Please try again");
            return response;
        }

        return response;

    }
}
