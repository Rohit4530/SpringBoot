package com.book.controller;

import com.book.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileController {
    @Autowired
    private FileUploadHelper helper;
    @PostMapping("/upload")
    public ResponseEntity<String> FileHandler(@PathVariable("file")MultipartFile file){
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
       // return new ResponseEntity<>("upload successful",HttpStatus.OK);
        try {
          boolean flag=  helper.uploadFile(file);
          if(flag){
            return   new ResponseEntity<>(ServletUriComponentsBuilder.fromCurrentContextPath().path(file.getOriginalFilename()).toUriString(),HttpStatus.OK);
          }
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
