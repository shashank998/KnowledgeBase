package com.altimetrik.knowledgeBase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.altimetrik.knowledgeBase.entity.Problems;
import com.altimetrik.knowledgeBase.serviceimpl.ArticleServiceImpl;

@RestController
public class ArticleController {

	@Autowired
	ArticleServiceImpl service;

	@PostMapping("/Save")
	public String addingProblems(@RequestParam String problemStatement, @RequestParam String problemDescription,
			@RequestParam String author, @RequestParam String solution, @RequestParam MultipartFile file)
			throws Exception {
		String dir = service.saveUploadedFiles(file);
		return service.save(problemStatement, problemDescription, author, solution, dir);
	}

	@GetMapping("/GetProblems")
	public List<Problems> getProblems(@RequestParam String problemStatement) {
		return service.get(problemStatement);
	}
}