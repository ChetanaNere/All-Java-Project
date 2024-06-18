package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.UploadFile;

@Repository
public interface FileProcessingRepository extends JpaRepository<UploadFile, Integer>{

}
