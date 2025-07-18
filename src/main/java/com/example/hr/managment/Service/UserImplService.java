package com.example.hr.managment.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.hr.managment.Entity.UserEntity;
import com.example.hr.managment.Model.UserModel;
import com.example.hr.managment.Repository.UserRepository;

@Service
public class UserImplService implements UserService{

  @Autowired
  UserRepository repository;

  public boolean login(String email, String password) {
     Optional<UserEntity> user = repository.findByEmail(email);
     // Check if the user exists and the password matches
     return user.isPresent() && user.get().getPassword().equals(password);
 }


 
 public Optional<UserEntity> findByEmp_email(String emp_email){
     return repository.findByEmail(emp_email);
 }

  public Long createusers(UserModel users){
    UserEntity entity = new UserEntity();
    if (users != null && users.getHr_id() == null){
      users.setHr_id((long)0);
      entity.setEmp_name(users.getEmp_name() !=null ? users.getEmp_name() :"");
      entity.setEmp_last_name(users.getEmp_last_name() !=null ? users.getEmp_last_name() :"");
      entity.setEmp_salary(users.getEmp_salary() !=null ? users.getEmp_salary() :"");
      entity.setEmp_age(users.getEmp_age() !=null ? users.getEmp_age() :"");
      entity.setAddress(users.getAddress() !=null ? users.getAddress() :"");
      entity.setEmp_panno(users.getEmp_panno() !=null ? users.getEmp_panno() :"");
      entity.setEmp_adharcard(users.getEmp_adharcard());
      entity.setEmail(users.getEmail() !=null ? users.getEmail() :"");
      entity.setEmp_date_of_joining(new Date());
      entity.setPassword(users.getPassword() !=null ? users.getPassword() :"");
      entity.setEmp_image_url(users.getEmp_image_url());

    }
    return repository.save(entity).getHr_id();
  }

  public List<UserModel> getAllUsers(){
    List<UserModel> response = new ArrayList<UserModel>();
    List<UserEntity> entity = repository.findAll();
    
    if (entity != null && entity.size() >0){
        entity.forEach(item ->{
         UserModel user = new UserModel();
         user.setHr_id(item.getHr_id());
         user.setEmp_name(item.getEmp_name());
         user.setEmp_last_name(item.getEmp_last_name());
         user.setEmp_salary(item.getEmp_salary());
         user.setEmp_age(item.getEmp_age());
         user.setAddress(item.getAddress());
         user.setEmp_panno(item.getEmp_panno());
         user.setEmp_adharcard(item.getEmp_adharcard());
         user.setEmail(item.getEmail());
         user.setEmp_date_of_joining(item.getEmp_date_of_joining());
         user.setPassword(item.getPassword());
         user.setEmp_image_url(item.getEmp_image_url());
         response.add(user);
        });
    }
    return response;

  }
  @Override 
  public UserModel getUserById(Long resourceId){
    Optional<UserEntity> request = repository.findById(resourceId);
    UserModel response = new UserModel();

    if (request.get() != null) {
    response.setHr_id(request.get().getHr_id());
    response.setEmp_name(request.get().getEmp_name());
    response.setEmp_last_name(request.get().getEmp_last_name());
    response.setEmp_salary(request.get().getEmp_salary());
    response.setEmp_age(request.get().getEmp_age());
    response.setAddress(request.get().getAddress());
    response.setEmp_panno(request.get().getEmp_panno());
    response.setEmp_adharcard(request.get().getEmp_adharcard());
    response.setEmail(request.get().getEmail());
    response.setEmp_date_of_joining(request.get().getEmp_date_of_joining());
    response.setEmp_image_url(request.get().getEmp_image_url());
    }
    return response;
  }
  @Override
  public String updateUser(UserModel user) {
      if (user != null) {
          Optional<UserEntity> request = repository.findById(user.getHr_id());

          if (request.isPresent()) {
              request.get().setEmp_name(user.getEmp_name());
              request.get().setEmp_last_name(user.getEmp_last_name());
              request.get().setEmp_salary(user.getEmp_salary());
              request.get().setEmp_age(user.getEmp_age());
              request.get().setAddress(user.getAddress());
              request.get().setEmp_panno(user.getEmp_panno());
              request.get().setEmp_adharcard(user.getEmp_adharcard());
              request.get().setEmail(user.getEmail());
              request.get().setEmp_date_of_joining(new Date());
              request.get().setEmp_image_url(user.getEmp_image_url());
              repository.save(request.get());
          }
          return "User updated successfully";
      } else {
          return "No update : User entity not found";
      }
  }

  @Override
    public String deleteUserById(Long resourceId) {
        if (repository.existsById(resourceId)) {
            repository.deleteById(resourceId);
            return "User with ID " + resourceId + " was successfully deleted.";
        } else {
            return "User with ID " + resourceId + " does not exist.";
        }
    }
}