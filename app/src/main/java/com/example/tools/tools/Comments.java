package com.example.tools.tools;

import java.util.List;

public class Comments {


    /**
     * comment_num : 0
     * like_num : 0
     * create_time : 2021-03-18T06:43:24.970Z
     * star_num : 0
     * tag : 0
     * author_id : 1
     * title : RE: 预习任务单07：大气环流
     * pics : ["http://122.9.2.27/media/image-20210303144633961_vafy7N2.png","http://122.9.2.27/media/image-20210303144658311.png"]
     * content : 6666666666666666
     */
    private int comment_num;
    private int like_num;
    private String create_time;
    private int star_num;
    private int tag;
    private int author_id;
    private String title,writer,photo;
    private List<String> pics;
    private String content,comment_writer,comment_content,error,noComments;


    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public String getWriter() {
        return writer;
    }

    public String getNoComments() {
        return noComments;
    }

    public void setNoComments(String noComments) {
        this.noComments = noComments;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setComment_writer(String comment_writer) {
        this.comment_writer = comment_writer;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getComment_writer() {
        return comment_writer;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public void setLike_num(int like_num) {
        this.like_num = like_num;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setStar_num(int star_num) {
        this.star_num = star_num;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getComment_num() {
        return comment_num;
    }

    public int getLike_num() {
        return like_num;
    }

    public String getCreate_time() {
        return create_time;
    }

    public int getStar_num() {
        return star_num;
    }

    public int getTag() {
        return tag;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getPics() {
        return pics;
    }

    public String getContent() {
        return content;
    }
}
