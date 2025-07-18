package com.example.hr.managment.Entity;

import java.util.Date;

import com.example.hr.managment.Model.UserModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "users")
@Entity
@Data
public class UserEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
  private String emp_image_url;  // ✅ Added image URL field

  // ✅ Default Constructor
  public UserEntity() { }

  // ✅ Constructor with UserModel
  public UserEntity(UserModel usermodel) {
        this.hr_id = usermodel.getHr_id();
        this.emp_name = usermodel.getEmp_name();
        this.emp_last_name = usermodel.getEmp_last_name();
        this.emp_salary = usermodel.getEmp_salary();
        this.emp_age = usermodel.getEmp_age();
        this.address = usermodel.getAddress();
        this.emp_panno = usermodel.getEmp_panno();
        this.emp_adharcard = usermodel.getEmp_adharcard();
        this.email = usermodel.getEmail();
        this.emp_date_of_joining = usermodel.getEmp_date_of_joining();
        this.password = usermodel.getPassword();
        this.emp_image_url = usermodel.getEmp_image_url();  // ✅ Add this line
  }
}
