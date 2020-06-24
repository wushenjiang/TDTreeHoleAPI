package com.liuge.domain;

import java.io.Serializable;

/**
 * @ClassName: Post
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/24  14:25
 */
public class Post implements Serializable {
    private int postid;
    private String postcontent;
    private String modifytime;
    private String posttime;
    private String title;
    private int userid;
    private String posttype;
    private String username;
    private Integer likes;
    private Integer comments;

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public String getPostcontent() {
        return postcontent;
    }

    public void setPostcontent(String postcontent) {
        this.postcontent = postcontent;
    }

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPosttype() {
        return posttype;
    }

    public void setPosttype(String posttype) {
        this.posttype = posttype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postid=" + postid +
                ", postcontent='" + postcontent + '\'' +
                ", modifytime='" + modifytime + '\'' +
                ", posttime='" + posttime + '\'' +
                ", title='" + title + '\'' +
                ", userid=" + userid +
                ", posttype='" + posttype + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
