package com.example.hr.managment.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hr.managment.Entity.EmployeeRepostDetailEntity;

@Repository
public interface EmployeeRepostDetailRepository extends JpaRepository<EmployeeRepostDetailEntity, Long> {
  // You can add custom query methods if needed
}