package com.example.demo.Resource;
import com.example.demo.Repository.EmployeeRepo;
import com.example.demo.ResourceNotFoundException;
import com.example.demo.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rest/v2")
@CrossOrigin(origins = "http://localhost:4200")

public class EmployeeResource {

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("/all")
    public List<Employees> showall(){
        return employeeRepo.findAll();
    }

    @PostMapping("/employees")
    public Employees addEmployee(@RequestBody Employees employee) {
        return employeeRepo.save(employee);
    }

    @DeleteMapping("/delete/{id}")
    public List<Employees> deleteEmployee(int id){
        employeeRepo.deleteById(id);
        return employeeRepo.findAll();
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable(value = "id") Integer employeeId,
                                                    @RequestBody Employees employeeDetails) throws ResourceNotFoundException {
        Employees employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEname(employeeDetails.getEname());
        employee.setEno(employeeDetails.getEno());

        final Employees updatedEmployee = employeeRepo.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
}
