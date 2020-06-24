package com.liuge.service.impl;

import com.liuge.dao.PostDao;
import com.liuge.domain.Likes;
import com.liuge.domain.Post;
import com.liuge.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: PostServiceImpl
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/24  14:23
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostDao postDao;

    @Override
    public List<Post> findAll() {
        List<Post> posts = postDao.findAll();
        return posts;
    }

    @Override
    public List<Post> findByType(int postType) {
        List<Post> postByType = postDao.findByType(postType);
        return postByType;
    }

    @Override
    public Post findPostById(Integer postId) {
        Post post = postDao.findPostById(postId);
        return post;
    }

    @Override
    public int addPost(Post post) {
        int result = postDao.addPost(post);
        return result;
    }

    @Override
    public int updateLike(Post post, Integer flag,Integer userId) {
        System.out.println(userId);
        int result = 0;
        if (flag == 1) {
            post.setLikes(post.getLikes()+1);
            result = postDao.addLikes(post);
            postDao.insertLike(post.getPostid(),userId);
        } else if (flag == 0 && post.getLikes() > 0) {
            post.setLikes(post.getLikes()-1);
            result = postDao.decreaseLikes(post);
            postDao.deleteLike(post.getPostid(),userId);
        }
        return result;
    }

    @Override
    public List<Likes> findLikesByPostId(Integer postId) {
        List<Likes> likes = postDao.findLikesByPostId(postId);
        return likes;
    }

    @Override
    public Integer findLikeForPost(Integer postId) {
        Integer result = postDao.findLikeForPost(postId);
        return result;
    }

    @Override
    public Integer findRepostForPost(Integer postid) {
        Integer result = postDao.findRepostForPost(postid);
        if(result == null){
            result = 0;
        }
        return result;
    }
}
