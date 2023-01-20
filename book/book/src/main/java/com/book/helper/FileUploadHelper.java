package com.book.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
   // public final String DIR_PATH="C:\\Users\\sangita\\Downloads\\book\\book\\src\\main\\resources\\static";
    public final String DIR_PATH=new ClassPathResource("static/images/").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {
    }

    public boolean uploadFile(MultipartFile multipartFile){
        boolean flag=false;
        try{
            Files.copy(multipartFile.getInputStream(), Paths.get(DIR_PATH+ File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            flag=true;
            return flag;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
