package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Comment;

@Repository
public class JUnitCommentRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Comment> COMMENT_ROW_MAPPER = (rs,i) -> {
		Comment comment = new Comment();
		comment.setId(rs.getInt("id"));
		comment.setName(rs.getString("name"));
		comment.setContent(rs.getString("content"));
		comment.setArticleId(rs.getInt("article_id"));
		return comment;
	};
	
	/**
	 * 主キー検索を行う
	 * @param id
	 * @return 検索されたコメント情報
	 */
	public Comment load(Integer id) {
		String sql = "SELECT id,name,content,article_id FROM comments WHERE id=:id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		Comment comment = template.queryForObject(sql, param, COMMENT_ROW_MAPPER);
		
		return comment;
	}
}
