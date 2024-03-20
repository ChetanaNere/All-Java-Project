package com.cjc.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int userID;
private String fullName;
private String username;
private String pancardNo;
private String email;
private long contactNo;
private long accNo;

@Lob
@Column(length=999999999)
private byte[] profileImage;
@Lob
@Column(length=999999999)
private byte[] adharCard;
@Lob
@Column(length=999999999)
 private byte[] panCard;
 
}
