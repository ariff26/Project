package com.example.demo.Service;

import com.example.demo.Model.Supplier;
import com.example.demo.Repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository repo;

    public SupplierService(SupplierRepository repo) {
        this.repo = repo;
    }

    public List<Supplier> getAllSuppliers() {
        return repo.findAll();
    }


}

