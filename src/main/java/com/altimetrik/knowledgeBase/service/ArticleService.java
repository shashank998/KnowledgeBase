package com.altimetrik.knowledgeBase.service;

import org.springframework.web.multipart.MultipartFile;

public interface ArticleService {

	String saveUploadedFiles(MultipartFile file) throws Exception;


}
