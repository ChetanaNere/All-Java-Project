package com.main.model;

public class PasswordResetRequest {
    private String token;
    private String email;
    private String newPassword;

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    @Override
    public String toString() {
        return "PasswordResetRequest{" +
                "token='" + token + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}