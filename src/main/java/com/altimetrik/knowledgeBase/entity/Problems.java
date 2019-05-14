package com.altimetrik.knowledgeBase.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Problems")
@Getter
@Setter
public class Problems {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String problemStatement;
	private String problemDescription;
	private String author;
	private Date problemDate;
	private String solution;
	private Date solvedDate;
	private String fileDir;
}
