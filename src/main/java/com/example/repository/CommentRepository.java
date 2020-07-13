package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Comment;

@Repository
public class CommentRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * 入力されたコメント情報を追加登録する
	 * @param comment
	 */
	public void insert(Comment comment) {
		String sql = "INSERT INTO comments(id,name,content,article_id)"
				+ " VALUES(:id,:name,:content,:articleId)";
		
		SqlParameterSource param = new BeanPropertySqlParameterSource(comment);
		
		template.update(sql, param);
	}
	
	/**
	 * 削除された投稿に関連するコメントを削除する
	 * @param articleId
	 */
	public void deleteByArticleId(int articleId) {
		String sql = "DELETE FROM comments WHERE id=:id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("articleId", articleId);
		
		template.update(sql, param);
	}
}
