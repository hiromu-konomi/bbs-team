package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.domain.Article;
import com.example.domain.Comment;
import com.example.repository.ArticleRepository;
import com.example.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository artRepository;

    @Autowired
    private CommentRepository comRepository;


    /**
     * @return List<Article>
     */
    public List<Article> showAll(){

        List<Article> artList = artRepository.findAll();
        List<Comment> comList = new ArrayList<Comment>();
        Map<Integer,Article> articleMap = new HashMap<Integer,Article>();
        Article article = new Article();

        for(Article art : artList){

            List<Comment> commentList = art.getCommentList();

            for(Comment comment : commentList){

                commentList.add(comment);

            }
        }

        for(Article art : artList){

            List<Comment> commentList = new ArrayList<>();

            for(Comment comment : commentList){

                if(Integer.valueOf(art.getId())==comment.getId()){

                    commentList.add(comment);

                }

            }

            art.setCommentList(commentList);
            articleMap.put(Integer.valueOf(article.getId()),article);

        }

        List<Article> articleList = new ArrayList<Article>(articleMap.values());

        return articleList;

    }


    /**
     * @param article
     */
    public void Insert(Article article){
        artRepository.insert(article);
    }


    /**
     * @param id
     */
    public void deleteById(Integer id){

        comRepository.deleteByArticleId(id);

        artRepository.delete(id);

    }

}