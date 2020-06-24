package com.liuge.service;

import com.liuge.domain.Likes;
import com.liuge.domain.Post;
import javafx.geometry.Pos;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName: PostService
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/24  14:22
 */
public interface PostService {
    /**
     * 返回所有帖子
     * @return
     */
    List<Post> findAll();

    /**
     * 根据帖子种类查询
     * @param postType
     * @return
     */
    List<Post> findByType(int postType);

    /**
     * 根据帖子id查找帖子
     * @param postId
     * @return
     */
    Post findPostById(Integer postId);

    /**
     * 发帖
     * @param post
     * @return
     */
    int addPost(Post post);

    /**
     * 更新点赞数
     * @param post
     * @param flag
     * @param userId
     * @return
     */
    int updateLike(Post post,Integer flag,Integer userId);

    /**
     * 根据帖子id查询点赞者的id
     * @param postId
     * @return
     */
    List<Likes> findLikesByPostId(Integer postId);

    /**
     * 根据帖子id查询到点赞数
     * @param postId
     * @return
     */
    Integer findLikeForPost(Integer postId);

    /**
     * 根据帖子id查询到评论数
     * @param postid
     * @return
     */
    Integer findRepostForPost(Integer postid);
}
