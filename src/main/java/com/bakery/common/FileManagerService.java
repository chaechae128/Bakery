package com.bakery.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileManagerService {

	//이미지 업로드 삭제
	
	//실제  업로드 된 이미지가 저장될 경로(서버의 주소)
	
	//학원용
	public static final String FILE_UPLOAD_PATH = "D:\\kimchaeyeon\\7_bakery_project\\bakery\\bakery_workspace\\images/";
	
	//input:File(원본) multipart, userLoginId(폴더명) output:이미지 경로
	public String saveFile(MultipartFile file) {
		//초로 구성된 폴더 
		//폴더(디렉토리)생성
		//예: manager_321865/cake.png
		String directoryName = "manager_" + System.currentTimeMillis();
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(filePath);
		if(directory.mkdir() == false) {
			return null;
		}
		
		//파일 업로드byte 단위로 업로드
		
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + "/" + file.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return "/images/" + directoryName + "/" + file.getOriginalFilename();
		
	}
	
	//input:imagePath output:x
	public void deleteFile(String imagePath) {
		//주소에 겹치는 /images/ 지운다.
		Path path = Paths.get(FILE_UPLOAD_PATH + imagePath.replace("/images", ""));
		//1) 삭제할 이미지 존재하는가
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				log.info("[파일매니저 삭제] 이미지 삭제 실패. path:{}", path.toString());
				return;
			}
			
			//폴더 삭제
			path = path.getParent();
			if(Files.exists(path)) {
				try {
					Files.delete(path);
				} catch (IOException e) {
					log.info("[파일매니저 삭제] 폴더 삭제 실패. path:{}", path.toString());
				}
			}
		}
	}
}
