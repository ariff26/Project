package com.example.demo.Controller;

import com.example.demo.Model.Supplier;
import com.example.demo.Service.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
@CrossOrigin(origins = "*")
public class SupplierController {

    private final SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @GetMapping
    public List<Supplier> getSuppliers() {
        return service.getAllSuppliers();
    }

}
