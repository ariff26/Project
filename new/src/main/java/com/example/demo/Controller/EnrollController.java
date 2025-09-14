package com.example.demo.Controller;

import com.example.demo.Model.Enroll;
import com.example.demo.Repository.EnrollRepository;
import com.example.demo.Service.EmailService;
import com.example.demo.Service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:5500")
public class EnrollController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private EnrollService enrollService;

    @Autowired
    private EnrollRepository enrollRepository;


    @PostMapping("/enroll")
    public void enroll(Enroll enroll){
        enrollRepository.save(enroll);
        System.out.println("Enroll Success!! We call back you soon!!!");
        emailService.sendEnrollmentEmailToAdmin(
                enroll.getName(),
                enroll.getEmail(),
                enroll.getCourse()
        );


    }

    @GetMapping("/total")
    public List<Enroll> getAll(){
        return enrollService.getAll();

    }






}

