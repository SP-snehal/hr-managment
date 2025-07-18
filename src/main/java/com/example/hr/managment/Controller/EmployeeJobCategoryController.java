package com.example.hr.managment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr.managment.Model.EmployeeModel;
import com.example.hr.managment.Service.EmployeeSerives;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employees")
public class EmployeeJobCategoryController {

    @Autowired
    EmployeeSerives service;

   
    @PostMapping()
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeModel request) {
        ResponseEntity<?> Respones;
        try {
            long result = service.addEmployee(request);
            return ResponseEntity.ok("Employee added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Failed: Invalid Data");
        }
    }

    
    @GetMapping()
    public List<EmployeeModel> getAllEmployees() {
        return service.getAllEmployees();
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id) {
        var result = service.getEmployeeById(id);
        return ResponseEntity.ok(result);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeModel resource) {
        if (id > 0) {
            resource.setJob_category_id(id);
            String result = service.updateEmployee(resource);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body("Not found");
    }


    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id) {
        return service.deleteEmployeeById(id);
    }
}
