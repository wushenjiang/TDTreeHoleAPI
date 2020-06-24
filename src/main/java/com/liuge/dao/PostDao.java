package com.liuge.dao;

import com.liuge.domain.Likes;
import com.liuge.domain.Post;
import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: PostDao
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/24  14:24
 */
@Repository
public interface PostDao {
    /**
     * 查找所有帖子
     * @return
     */
    List<Post> findAll();

    /**
     * 根据类型查找帖子
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
     * 增加点赞数
     * @param post
     * @return
     */
    int addLikes(Post post);

    /**
     * 向likes表插入点赞id
     * @param userId
     * @param postId
     * @return
     */
    void insertLike(@Param("postId") Integer postId,@Param("userId") Integer userId);
    /**
     * 减少点赞数
     * @param post
     * @return
     */
    int decreaseLikes(Post post);

    /**
     * 删除点赞者的id
     * @param userId
     * @param postId
     * @return
     */
    void deleteLike(@Param("postId") Integer postId,@Param("userId") Integer userId);
    /**
     * 根据帖子id查询所有点赞的id
     * @param postId
     * @return
     */
    List<Likes> findLikesByPostId(Integer postId);

    /**
     * 根据帖子id查询帖子点赞数
     * @param postId
     * @return
     */
    Integer findLikeForPost(Integer postId);

    /**
     * 根据帖子id查询帖子评论数
     * @param postId
     * @return
     */
    Integer findRepostForPost(Integer postId);
}
