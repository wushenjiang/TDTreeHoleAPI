package com.liuge.domain;

/**
 * @ClassName: Likes
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/27  21:00
 */
public class Likes {

    private Integer id;
    private Integer postid;
    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
