package com.altimetrik.knowledgeBase.serviceimpl;

import java.nio.file.Files;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.altimetrik.knowledgeBase.entity.Problems;
import com.altimetrik.knowledgeBase.exception.RecordNotFoundException;
import com.altimetrik.knowledgeBase.repository.ProblemRepo;
import com.altimetrik.knowledgeBase.service.ArticleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ProblemRepo repo;

	ArticleServiceImpl service;

	@Value("${filepath-dir}")
	private String filePath;

	@Override
	public String saveUploadedFiles(MultipartFile file) throws Exception {

		log.info("File storing directory {}", filePath);

		if (file.isEmpty()) {
			throw new Exception("File Not found");
		}

		byte[] bytes = file.getBytes();
		String storedPath = filePath + file.getOriginalFilename() + "_" + System.currentTimeMillis();
		Path path = Paths.get(storedPath);
		Files.write(path, bytes);
		return storedPath;

	}

	public String save(String problemStatement, String problemDescription, String author, String solution, String dir) {
		Problems p = new Problems();
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		p.setProblemStatement(problemStatement);
		p.setProblemDescription(problemDescription);
		p.setAuthor(author);
		p.setProblemDate(date);
		p.setSolution(solution);
		p.setSolvedDate(date);
		p.setFileDir(dir);

		repo.save(p);
		return "Problem saved successsfully";
	}

	public List<Problems> get(String problemStatement) {
		List<Problems> p = repo.getByProblemStatement(problemStatement);
		if (p.isEmpty()) {
			throw new RecordNotFoundException("Problem not found");
		}

		return p;
	}

}
