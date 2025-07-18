package com.example.hr.managment.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.hr.managment.Entity.EmployeeEntity;

@Repository
public interface EmployeeJobCategoryRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query(value = """
        SELECT worker_name, job_title, start_time, end_time, 
               AGE(end_time::TIMESTAMP, start_time::TIMESTAMP) AS total_work_hours 
        FROM employee_job_categories
    """, nativeQuery = true)
    List<Object[]> getEmployeeWorkHours();
}
