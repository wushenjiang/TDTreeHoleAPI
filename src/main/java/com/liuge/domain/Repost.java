package com.liuge.domain;

import java.io.Serializable;

/**
 * @ClassName: Repost
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/24  18:02
 */
public class Repost implements Serializable {
    private int repostid;
    private String modifytime;
    private String publishtime;
    private int postid;
    private int userid;
    private String content;
    private String username;

    public int getRepostid() {
        return repostid;
    }

    public void setRepostid(int repostid) {
        this.repostid = repostid;
    }

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Repost{" +
                "repostid=" + repostid +
                ", modifytime='" + modifytime + '\'' +
                ", publishtime='" + publishtime + '\'' +
                ", postid=" + postid +
                ", userid=" + userid +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
