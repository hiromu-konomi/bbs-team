package com.example.repository;

import java.util.List;

import com.example.domain.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Article> ARTICLE_ROW_MAPPER = (rs,i) ->{

        Article article = new Article();

        article.setId(rs.getString("id"));
        article.setName(rs.getString("name"));
        article.setContent(rs.getString("content"));

        return article;

    };


    /**
     * @return List<Article>
     */
    public List<Article> findAll() {

        String sql = "select art.id, art.name, art.content, com.name, com.name, com.article_id from articles as art join comments as com on art.id = com.article_id order by id asc";

        List<Article> articleList = template.query(sql, ARTICLE_ROW_MAPPER);

        return articleList;

    }


    /**
     * @param article
     */
    public void insert(Article article){

        String sql = "insert into article (name, content) values (:name, :content)";

        SqlParameterSource param = new MapSqlParameterSource().addValue("name",article.getName()).addValue("content",article.getContent());

        template.update(sql, param);

    }


    /**
     * @param id
     */
    public void delete(int id){

        String sql = "delete from articles where id = :id";

        SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);

        template.update(sql, param);

    }

}