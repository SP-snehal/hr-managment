package com.example.hr.managment.Entity;

import java.time.LocalTime;

import com.example.hr.managment.Model.EmployeeModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Table(name = "employee_job_categories")
@Entity
@Data
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long job_category_id;
    
    private String worker_name;
    private String job_title;
    private String department;
    private LocalTime start_time;
    private LocalTime end_time;

    @Transient // This field is not stored in the database
    private String totalWorkHours;

    // Default Constructor
    public EmployeeEntity() {
    }

    // Constructor to Map from EmployeeModel
    public EmployeeEntity(EmployeeModel employeeModel) {
        this.job_category_id = employeeModel.getJob_category_id();
        this.worker_name = employeeModel.getWorker_name();
        this.job_title = employeeModel.getJob_title();
        this.department = employeeModel.getDepartment();
        this.start_time = employeeModel.getStart_time();
        this.end_time = employeeModel.getEnd_time();
        this.totalWorkHours = employeeModel.getTotalWorkHours();
    }
}
