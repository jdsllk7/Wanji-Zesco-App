package com.telusko.demo.service;

import com.telusko.demo.enums.Response;
import com.telusko.demo.model.Equipment;
import com.telusko.demo.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Transactional(rollbackOn = Exception.class)

    public Map<String, Object> save(HttpServletRequest request) {

        Map<String, Object> response = new HashMap<>();

        try {

            String name = request.getParameter("name");
            String description = request.getParameter("description");

            Equipment equipment = new Equipment();
            equipment.setName(name);
            equipment.setDescription(description);
            equipmentRepository.save(equipment);

            response.put(Response.STATUS, Response.SUCCESS);

        } catch (Exception e) {
            response.put(Response.STATUS, Response.ERROR);
            response.put(Response.MESSAGE, "An error occurred. Please try again");
            return response;
        }

        return response;

    }

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    public Equipment getEquipmentById(Integer id) {
        return equipmentRepository.findFirstById(id);
    }
}
