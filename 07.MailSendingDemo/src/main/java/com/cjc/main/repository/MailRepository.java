package com.cjc.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.model.MyMail;
@Repository
public interface MailRepository extends JpaRepository<MyMail, Integer>{

}
