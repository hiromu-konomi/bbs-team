package com.example.form;

public class ArticleForm {

    private String id;
    private String name;
    private String content;

    public ArticleForm() {
    }

    public ArticleForm(String id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
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
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", content='" + getContent() + "'" +
            "}";
    }


}