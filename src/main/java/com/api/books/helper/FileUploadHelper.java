package com.api.books.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	//public final String UPLOAD_DIR="C:\\Users\\Ashish Yadav\\Documents\\workspace-spring-tool-suite-4-4.20.0.RELEASE\\restapipractice\\src\\main\\resources\\static\\images";
	public final String UPLOAD_DIR= new ClassPathResource("static/images/").getFile().getAbsolutePath() ;
	
	public FileUploadHelper() throws IOException {
		
	}

	public boolean uplaodFile(MultipartFile file) {
		boolean f=false;
		try {
			
			Files.copy(file.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			f=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return f;
	}
}
