package com.main.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.exception.TokenExpiredException;
import com.main.exception.TokenNotFoundException;
import com.main.exception.UsernameNotFoundException;
import com.main.model.PasswordResetToken;
import com.main.model.User;
import com.main.repository.PasswordResetTokenRepository;
import com.main.repository.UserRepository;

@Service
public class PasswordResetTokenService {

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;

    public PasswordResetToken createToken(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }

        User user = optionalUser.get();
        PasswordResetToken token = new PasswordResetToken();
        token.setUser(user);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(LocalDateTime.now().plusHours(1));
        tokenRepository.save(token);
        return token;
    }

//    public boolean validateToken(String token) {
//        Optional<PasswordResetToken> optionalToken = tokenRepository.findByToken(token);
//        if (!optionalToken.isPresent()) {
//            throw new IllegalArgumentException("Invalid token");
//        }
//
//        PasswordResetToken resetToken = optionalToken.get();
//        return resetToken.getExpiryDate().isAfter(LocalDateTime.now());
//    }
    public boolean validateToken(String token) {
        Optional<PasswordResetToken> optionalToken = tokenRepository.findByToken(token);
        if (!optionalToken.isPresent()) {
            throw new TokenNotFoundException("Token not found");
        }

        PasswordResetToken resetToken = optionalToken.get();
        if (resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new TokenExpiredException("Token has expired");
        }

        return true;
    }
}
