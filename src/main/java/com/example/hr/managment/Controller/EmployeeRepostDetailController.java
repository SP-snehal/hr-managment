package com.example.hr.managment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hr.managment.Model.EmployeeRepostDetailModel;
import com.example.hr.managment.Service.EmployeeRepostDetailImplService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee-reports")
public class EmployeeRepostDetailController {

    @Autowired
    private EmployeeRepostDetailImplService service;

    // 1️⃣ Add Employee Report
    @PostMapping()
    public ResponseEntity<?> addReport(@RequestBody EmployeeRepostDetailModel request) {
        try {
            Long reportId = service.addReport(request);
            return ResponseEntity.ok("Report added successfully with ID: " + reportId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add report: Invalid Data");
        }
    }

    // 2️⃣ Get All Employee Reports
    @GetMapping()
    public ResponseEntity<List<EmployeeRepostDetailModel>> getAllReports() {
        List<EmployeeRepostDetailModel> reports = service.getAllReports();
        return ResponseEntity.ok(reports);
    }

    // 3️⃣ Get Report by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getReportById(@PathVariable("id") Long id) {
        EmployeeRepostDetailModel report = service.getReportById(id);
        if (report != null) {
            return ResponseEntity.ok(report);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Report with ID " + id + " not found.");
    }

    // 4️⃣ Update Employee Report
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReport(@PathVariable("id") Long id, @RequestBody EmployeeRepostDetailModel request) {
        if (id > 0) {
            request.setId(id);
            String result = service.updateReport(request);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body("Invalid ID");
    }

    // 5️⃣ Delete Report by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReportById(@PathVariable("id") Long id) {
        String result = service.deleteReportById(id);
        return ResponseEntity.ok(result);
    }
}
