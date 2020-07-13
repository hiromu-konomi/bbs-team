package com.example.controller;

import java.util.List;

import com.example.domain.Article;
import com.example.domain.Comment;
import com.example.form.ArticleForm;
import com.example.form.CommentForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleController {
    
    @ModelAttribute
    public ArticleForm setUpForm1(){
        return new ArticleForm();
    }

    @ModelAttribute
    public CommentForm setUpForm2(){
        return new CommentForm();
    }

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;


    @RequestMapping("")
    public String index(Model model){
        List<Article> articleList =articleService.findAll();
        model.addAttribute("articleList",articleList);
        List<Comment> commentList=commentService.findAll();
        model.addAttribute("commentList",commentList);
        return "bbs";
    }

    @RequestMapping("/insert-article")
    public String insertArticle(ArticleForm form,Model model){
        Article article =new Article();
        article.setName(form.getName());
        article.setContent(form.getContent());

        articleService.insert(article);
        return index(model);
    }

    @RequestMapping("/insert-comment")
    public String insertComment(CommentForm form,Model model){
        Comment comment=new Comment();
        comment.setName(form.getName());
        comment.setContent(form.getContent());

        commentService.insert(comment);
        return index(model);
    }

    @RequestMapping("/delete-article")
    public String deleteArticle(Model model,String articleId){
        articleService.deleteByArticleId(articleId);
        return index(model);
    }
}