package com.main.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Admin;
import com.main.model.Event;
import com.main.model.Leave;
import com.main.model.Staff;
import com.main.model.Student;
import com.main.model.Teacher;
import com.main.model.User;
import com.main.repository.EventRepository;
import com.main.service.UserService;

@RestController
@CrossOrigin("*")
//@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;
   
//    @PostMapping("/registerUser")
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
//        User registeredUser = userService.registerUser(user);
//        return ResponseEntity.ok(registeredUser);
//    }
    
    @PostMapping("/registerUser")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.ok(registeredUser);
        } catch (Exception e) {
            e.printStackTrace();  // Log the error details
            return ResponseEntity.status(500).body(null);  // Return a 500 status with no body
        }
    }

    @GetMapping("/getByName/{username}/{password}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username,@PathVariable String password) {
        User user = userService.loginUser(username,password);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
    
    
    @GetMapping("/getAllUser")
    public List<User> getAllUsers()
    {
    	return userService.getAllUsers();
		
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);
        return user.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return userService.getAllStudents();
    }

    // Get all teachers
    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return userService.getAllTeachers();
    }

    // Get all staff
    @GetMapping("/staff")
    public List<Staff> getAllStaff() {
        return userService.getAllStaff();
    }

    // Get all admins
    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return userService.getAllAdmins();
    }
    
    @GetMapping("/role/{role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable String role) {
        List<User> users = userService.findByRole(role);
        return ResponseEntity.ok(users);
    }
    
  

    @GetMapping("localdate")
    public List<Event> getEvents() {
      return userService.findAll();
    }
    
    @PostMapping("/leavesRequest")
    public ResponseEntity<Leave> submitLeaveRequest(@RequestBody Leave leaveRequest) {
        Leave newLeaveRequest = userService.submitLeaveRequest(leaveRequest);
        return new ResponseEntity<Leave>(newLeaveRequest, HttpStatus.CREATED);
    }
   
    @GetMapping("getLeaveRequestById/{id}")
    public ResponseEntity<Leave> getLeaveRequestById(@PathVariable Long id) {
        Leave leaveRequest = userService.getLeaveRequestById(id);
        return new ResponseEntity<>(leaveRequest, HttpStatus.OK);
    }
    
    @GetMapping("/leaves")
    public List<Leave> getLeaves() {
        return userService.getfindAllLeaves();
    }

    @PutMapping("/leaves/{id}/status")
    public ResponseEntity<Leave> updateLeaveStatus(@PathVariable Long id, @RequestBody Map<String, String> status) {
    	userService.updateLeaveStatus(id, status.get("status"));
        return ResponseEntity.ok().build();
    }
}
