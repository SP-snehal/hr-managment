package com.example.hr.managment.Model;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Data
@NoArgsConstructor
public class EmployeeModel {
    
    private Long job_category_id;
    
    private String worker_name;
    private String job_title;
    private String department;
    private LocalTime start_time;
    private LocalTime end_time;
    
    private String totalWorkHours; // No need for @Transient here
}

