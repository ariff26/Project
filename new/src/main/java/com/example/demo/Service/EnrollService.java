package com.example.demo.Service;

import com.example.demo.Model.Enroll;
import com.example.demo.Repository.EnrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollService {
    @Autowired
    EnrollRepository enrollRepository;

//    public void addEnroll(Enroll enroll) {
//        enrollRepository.save(enroll);
//    }

    public List<Enroll> getAll() {
        return enrollRepository.findAll();
    }

}
