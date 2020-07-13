package com.example.domain;

import java.util.List;

public class Article {

    /**
     *
     * param id
     * param name
     * param content
     * param commentList
     */

    private String id;
    private String name;
    private String content;
    private List<Comment> commentList;


    public Article() {
    }

    public Article(String id, String name, String content, List<Comment> commentList) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.commentList = commentList;
    }


    /**
     * @return String
     */
    public String getId() {
        return this.id;
    }


    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }


    /**
     * @return String
     */
    public String getName() {
        return this.name;
    }


    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return String
     */
    public String getContent() {
        return this.content;
    }


    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }


    /**
     * @return List<Comment>
     */
    public List<Comment> getCommentList() {
        return this.commentList;
    }


    /**
     * @param commentList
     */
    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }


    /**
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", content='" + getContent() + "'" +
            ", commentList='" + getCommentList() + "'" +
            "}";
    }


}