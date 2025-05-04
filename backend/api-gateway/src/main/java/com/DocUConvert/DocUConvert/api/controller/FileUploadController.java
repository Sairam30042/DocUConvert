package com.DocUConvert.DocUConvert.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import com.DocUConvert.DocUConvert.api.repository.FileUploadJobRepository;
import com.DocUConvert.DocUConvert.datatransferobject.UploadResponse;
import com.DocUConvert.DocUConvert.model.FileUploadJob;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class FileUploadController {

    @Autowired
    private FileUploadJobRepository fileUploadJobRepository;

    public static final String UPLOAD_DIR = "/tmp/uploads";

    @PostMapping("/upload")
    public ResponseEntity<UploadResponse> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("target_format") String targetFormat) {
        try {
            // Save the file to the server
            String uploadDir = "/tmp/uploads";
            Files.createDirectories(Path.of(uploadDir));
            String filePath = uploadDir + "/" + file.getOriginalFilename();
            
            file.transferTo(new File(filePath));
            FileUploadJob job = new FileUploadJob(file.getOriginalFilename(), filePath, targetFormat, "PENDING");
            UploadResponse response = new UploadResponse(file.getOriginalFilename(), job.getId(), targetFormat, "PENDING");
            //UploadResponse uploadResponse = new UploadResponse(job.getName(), job.getId(), job.getTargetFormat(), job.getStatus());
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
}
