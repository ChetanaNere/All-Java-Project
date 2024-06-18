package com.main.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.exception.UsernameNotFoundException;
import com.main.model.PasswordResetRequest;
import com.main.model.PasswordResetToken;
import com.main.service.EmailService;
import com.main.service.PasswordResetTokenService;
import com.main.service.UserService;

@RestController
@CrossOrigin("*")
//@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	UserService userService;
	
    @Autowired
    private PasswordResetTokenService tokenService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/request-reset")
    public ResponseEntity<Map<String, String>> requestReset(@RequestBody PasswordResetRequest request) {
        PasswordResetToken token = tokenService.createToken(request.getEmail());
        emailService.sendResetMail(request.getEmail(), token.getToken());
        Map<String, String> response = new HashMap<>();
      response.put("message", "Reset link sent");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Map<String, String>> resetPassword(@RequestBody PasswordResetRequest request) {
        Map<String, String> response = new HashMap<>();
        if (tokenService.validateToken(request.getToken())) {
            userService.updatePassword(request.getEmail(), request.getNewPassword());
            response.put("message", "Password reset successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid or expired token");
            return ResponseEntity.badRequest().body(response);
        }
    }
   
}