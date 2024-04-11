package com.cjc.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
@Id
private long accno;
private String name;
private long mobno;
private long adharno;
private String gender;
private int age;
private double balence;



public long getAccno() {
	return accno;
}
public void setAccno(long accno) {
	this.accno = accno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getMobno() {
	return mobno;
}
public void setMobno(long mobno) {
	this.mobno = mobno;
}
public long getAdharno() {
	return adharno;
}
public void setAdharno(long adharno) {
	this.adharno = adharno;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public double getBalence() {
	return balence;
}
public void setBalence(double balence) {
	this.balence = balence;
}

}
