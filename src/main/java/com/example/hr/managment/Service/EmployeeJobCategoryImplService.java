package com.example.hr.managment.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr.managment.Entity.EmployeeEntity;
import com.example.hr.managment.Model.EmployeeModel;
import com.example.hr.managment.Repository.EmployeeJobCategoryRepository;


@Service
public class EmployeeJobCategoryImplService implements EmployeeSerives {

    @Autowired
    EmployeeJobCategoryRepository repository;

    // 3️⃣ Get All Employees
    public List<EmployeeModel> getAllEmployees() {
        List<EmployeeModel> response = new ArrayList<>();
        List<EmployeeEntity> entity = repository.findAll();

        if (entity != null && entity.size() >0) {
            entity.forEach(item -> {
                EmployeeModel employee = new EmployeeModel();
               employee.setJob_category_id(item.getJob_category_id());
               employee.setWorker_name(item.getWorker_name());
               employee.setJob_title(item.getJob_title());
               employee.setDepartment(item.getDepartment());
               employee.setStart_time(item.getStart_time());
               employee.setEnd_time(item.getEnd_time());
               employee.setTotalWorkHours(item.getTotalWorkHours());
                response.add(employee);
            });
        }
        return response;
    }

    @Override
    public EmployeeModel getEmployeeById(Long resourceId) {
        Optional<EmployeeEntity> request = repository.findById(resourceId);
        EmployeeModel response = new EmployeeModel();

        if (request.get() != null) {
            response.setJob_category_id(request.get().getJob_category_id());
            response.setWorker_name(request.get().getWorker_name());
            response.setJob_title(request.get().getJob_title());
            response.setDepartment(request.get().getDepartment());
            response.setStart_time(request.get().getStart_time());
            response.setEnd_time(request.get().getEnd_time());
            response.setTotalWorkHours(request.get().getTotalWorkHours());
        }
        return response;
    }

    @Override
    public Long addEmployee(EmployeeModel employee) {
        EmployeeEntity entity = new EmployeeEntity();

        if (employee != null && employee.getJob_category_id() == null) {
            employee.setJob_category_id((long)0);
            entity.setWorker_name(employee.getWorker_name() != null ? employee.getWorker_name() : "");
            entity.setJob_title(employee.getJob_title() != null ? employee.getJob_title() : "");
            entity.setDepartment(employee.getDepartment() != null ? employee.getDepartment() : "");
            entity.setStart_time(employee.getStart_time());
            entity.setTotalWorkHours(employee.getTotalWorkHours());
            entity.setEnd_time(employee.getEnd_time());
        }

        return repository.save(entity).getJob_category_id();
    }

    // 6️⃣ Update Employee
    public String updateEmployee(EmployeeModel employee) {
        if (employee != null) {
            Optional<EmployeeEntity> request = repository.findById(employee.getJob_category_id());

            if (request.isPresent()) {
                EmployeeEntity entity = request.get();
                entity.setWorker_name(employee.getWorker_name());
                entity.setJob_title(employee.getJob_title());
                entity.setDepartment(employee.getDepartment());
                entity.setStart_time(employee.getStart_time());
                entity.setEnd_time(employee.getEnd_time());
                entity.setTotalWorkHours(employee.getTotalWorkHours());
                repository.save(entity);
                return "Employee updated successfully";
            }
        }
        return "No update: Employee entity not found";
    }

    // 7️⃣ Delete Employee
    public String deleteEmployeeById(Long resourceId) {
        if (repository.existsById(resourceId)) {
            repository.deleteById(resourceId);
            return "Employee with ID " + resourceId + " was successfully deleted.";
        } else {
            return "Employee with ID " + resourceId + " does not exist.";
        }
    }
}
