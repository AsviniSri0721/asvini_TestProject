package com.example.demo.Repository;

import com.example.demo.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employees,Integer> {
}
