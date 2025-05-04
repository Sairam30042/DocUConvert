package com.DocUConvert.DocUConvert.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DocUConvert.DocUConvert.model.FileUploadJob;
import org.springframework.stereotype.Repository;
@Repository
public interface FileUploadJobRepository extends JpaRepository<FileUploadJob, Long> {
    // Custom query methods can be defined here if needed
    // For example, to find jobs by status:
    List<FileUploadJob> findByStatus(String status);
    
}
