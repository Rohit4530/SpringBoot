package com.book.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
    @PostMapping("/upload")
    public ResponseEntity<String> FileHandler(@PathVariable("file")MultipartFile file){
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        return new ResponseEntity<>("upload successful",HttpStatus.OK);
    }
}
