package com.example.hr.managment.Model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Data
@NoArgsConstructor
public class UserModel {
  private Long hr_id;
    private String emp_name;
    private String emp_last_name;
    private String emp_salary;
    private String emp_age;
    private String address;
    private String emp_panno;
    private Long emp_adharcard;
    private String email;
    private Date emp_date_of_joining;
    private String password;
    private String emp_image_url; 
}
