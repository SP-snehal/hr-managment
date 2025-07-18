package com.example.hr.managment.Service;
import java.util.List;

import com.example.hr.managment.Model.UserModel;

public interface  UserService {
  
    public Long createusers(UserModel users);

    public List<UserModel> getAllUsers();

    public UserModel getUserById(Long resourceId);

    public String updateUser(UserModel user);

    public String deleteUserById(Long resourceId);

    public boolean login(String emp_email, String password);
  }
  
