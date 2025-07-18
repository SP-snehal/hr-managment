package com.example.hr.managment.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import  org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr.managment.Model.UserModel;
import com.example.hr.managment.Repository.AuthRequestmodel;
import com.example.hr.managment.Service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/users")
public class UserController {
  
  @Autowired
  UserService service;

  @PostMapping()
  public ResponseEntity<?> createUsersNEntity(@RequestBody UserModel request){

    ResponseEntity<?> Response;
    try{
      long result = service.createusers(request);
      Response = ResponseEntity.ok("User created successfully");
      return Response;
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)

        .body("Faild: Invalid Datal");
    }

  }

  @GetMapping()
  public List<UserModel> getAllUsers() {
      return service.getAllUsers();
  }


  @GetMapping("/{id}")
  public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
    var result = service.getUserById(id);
    return ResponseEntity.ok(result);
}

  @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserModel resource) {
        if (id > 0) {
            resource.setHr_id(id);
            String result = service.updateUser(resource);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body("Not found");
    }


    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        return service.deleteUserById(id);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequestmodel authRequest) {
        
         boolean isAuthenticated = service.login(authRequest.getEmp_email(), authRequest.getPassword());
        if (isAuthenticated) {
            return "Login successful!";
        } else {
            return "Invalid credentials!";
        }
    }


}
