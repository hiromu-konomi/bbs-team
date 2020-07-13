package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Comment;
import com.example.repository.CommentRepository;

@Service
@Transactional
public class CommentService {

	@Autowired
	private CommentRepository repository;
	
	public void insert(Comment comment) {
		repository.insert(comment);
	}
	
	public void deleteByArticleId(int articleId) {
		repository.deleteByArticleId(articleId);
	}
}
