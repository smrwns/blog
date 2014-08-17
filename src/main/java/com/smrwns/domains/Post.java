package com.smrwns.domains;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("Post")
public class Post {
    private Long id;
    private String author;
    private String subject;
    private String content;
    private Long CategoryId;
    private Date posted;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public Long getCategoryId() {
        return CategoryId;
    }
    
    public void setCategoryId(Long categoryId) {
        CategoryId = categoryId;
    }
    
    public Date getPosted() {
        return posted;
    }
    
    public void setPosted(Date posted) {
        this.posted = posted;
    }
    
}
