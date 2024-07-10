package com.main.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.main.exception.ResourceNotFoundException;
import com.main.exception.ResourceNotFoundException;
import com.main.exception.UsernameNotFoundException;
import com.main.model.Admin;
import com.main.model.Event;
import com.main.model.Leave;
import com.main.model.Staff;
import com.main.model.Student;
import com.main.model.Teacher;
import com.main.model.User;
import com.main.repository.AdminRepository;
import com.main.repository.EventRepository;
import com.main.repository.LeaveRepository;
import com.main.repository.StaffRepository;
import com.main.repository.StudentRepository;
import com.main.repository.TeacherRepository;
import com.main.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    TeacherRepository teacherRepository;
    
    @Autowired
    StaffRepository staffRepository;
    
    @Autowired
    AdminRepository adminRepository;
    
    @Autowired
    private EventRepository eventRepository;
    
    @Autowired
    private LeaveRepository leaveRepository;

    
    // Registration logic
    public User registerUser(User user) {
           return userRepository.save(user);
     }


    // Login logic
    public User loginUser(String username, String password) {
    	 return userRepository.findByUsernameAndPassword(username, password);
    
    }

    public List<User> getAllUsers()
    {
		return userRepository.findAll();
    }
   
    
    public void updatePassword(String email, String newPassword) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Now you have the User object, so you can set the password
            user.setPassword(newPassword); // Make sure to encode the password
            userRepository.save(user);
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }


    public Optional<User> findByToken(String token) {
        return userRepository.findByResetToken(token);
    }


	public Optional<User> findUserById(Long id) {
		return userRepository.findById(id);
		 
	}

	 public List<Student> getAllStudents() {
	      
	        return studentRepository.findAll();
	    }
	    
	    public List<Teacher> getAllTeachers() {
	       
	        return teacherRepository.findAll();
	    }


		public List<Staff> getAllStaff() {
			
			return staffRepository.findAll();
		}


		public List<Admin> getAllAdmins() {
			return adminRepository.findAll();
		}
   
		 public List<User> findByRole(String role) {
		        return userRepository.findByRole(role);
		    }


		public List<Event> findAll() {
			// TODO Auto-generated method stub
			return eventRepository.findAll();
		}
		

		public Leave submitLeaveRequest(Leave leaveRequest) {
	        return leaveRepository.save(leaveRequest);
	    }
		
		 public Leave getLeaveRequestById(Long id) {
		        return leaveRepository.findById(id)
		                .orElseThrow(() -> new ResourceNotFoundException("Leave request not found with id: " + id));
		    }

	    public List<Leave> getfindAllLeaves() {
	        return leaveRepository.findAll();
	    }

	    public void updateLeaveStatus(Long id, String status) {
	        Leave leave = leaveRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Leave not found"));
	        leave.setStatus(status);
	        leaveRepository.save(leave);
	    }
}
