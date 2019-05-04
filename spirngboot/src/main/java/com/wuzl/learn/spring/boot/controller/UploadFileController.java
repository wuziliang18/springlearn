package com.wuzl.learn.spring.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller

public class UploadFileController {
	
	
	@RequestMapping("/upload/index")
	public String index() {
		return "upload";
	}
	/**
	 * 单文件上传
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/uploadone")
	@ResponseBody public String uploadOne(MultipartFile file) throws Exception {

		return "success";
	}
	
	@RequestMapping("/upload")
	@ResponseBody  public String upload(HttpServletRequest request) throws Exception {
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		for (int i = 0; i < files.size(); i++) {
			MultipartFile file = files.get(i);
			if (file.isEmpty()) {
				return "上传第" + (i++) + "个文件失败";
			}
			String fileName = file.getOriginalFilename();
			System.out.println(fileName);
		}

		return "success";
	}
}
