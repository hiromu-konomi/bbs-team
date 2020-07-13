package com.example.repository;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Comment;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommentRepositoryTest {
	
	@Autowired
	private CommentRepository commentRepository;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void insert() {
		Comment comment = new Comment();
		comment.setId(1);
		comment.setName("峯田和伸");
		comment.setContent("ロックンロール！");
		comment.setArticleId(1);
		commentRepository.insert(comment);
	}

}
