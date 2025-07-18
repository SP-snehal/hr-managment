package com.example.hr.managment.Service;

import java.util.List;

import com.example.hr.managment.Model.EmployeeModel;

public interface EmployeeSerives {
   public Long addEmployee(EmployeeModel employee);
   public List<EmployeeModel> getAllEmployees();
   public EmployeeModel getEmployeeById(Long resourceId);
   public String updateEmployee(EmployeeModel employee);
   public String deleteEmployeeById(Long resourceId);
   
}
