package com.liuge.controller;

import com.google.gson.Gson;
import com.liuge.domain.Likes;
import com.liuge.domain.Post;
import com.liuge.service.PostService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: PostController
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/24  14:21
 */
@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;
    private Gson gson = new Gson();;


    private void setEncoding(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public void findAll(HttpServletResponse response) throws IOException {
        List<Post> posts = postService.findAll();
        String jsonStr = gson.toJson(posts);
        setEncoding(response);
        response.getWriter().write(jsonStr);
    }
    @RequestMapping(value = "/findPostById",method = RequestMethod.GET)
    public void findPostById(HttpServletResponse response,@RequestParam("postId") Integer postId) throws IOException {
        Post post = postService.findPostById(postId);
        setEncoding(response);
        String jsonStr = gson.toJson(post);
        response.getWriter().write(jsonStr);
    }


    @RequestMapping(value = "/findByType",method = RequestMethod.GET)
    public void findByType(HttpServletResponse response, @RequestParam int postType) throws IOException{
        List<Post> postsByType = postService.findByType(postType);
        String jsonStr = gson.toJson(postsByType);
        setEncoding(response);
        response.getWriter().write(jsonStr);
    }
    @RequestMapping(value = "/addPost",method = RequestMethod.POST)
    public void addPost(HttpServletResponse response,@RequestBody  Post post) throws IOException {
        int result = postService.addPost(post);
        System.out.println(result);
        setEncoding(response);
        String json = gson.toJson(result);
        response.getWriter().write(json);
    }
    @PostMapping(value = "/updateLike")
    public void updateLike(HttpServletResponse response, @RequestBody Map<String,Object> map) throws IOException {
        String jsonPost = gson.toJson(map.get("post"));
        Post post = gson.fromJson(jsonPost, Post.class);
        String jsonFlag = gson.toJson(map.get("flag"));
        Integer flag = gson.fromJson(jsonFlag,Integer.TYPE);
        String jsonUser = gson.toJson(map.get("userId"));
        Integer userId = gson.fromJson(jsonUser,Integer.TYPE);
        System.out.println(userId);
        int result = postService.updateLike(post,flag,userId);
        setEncoding(response);
        String json = gson.toJson(result);
        response.getWriter().write(json);
    }
    @RequestMapping(value = "/findLikes",method = RequestMethod.GET)
    public void findLikesByPostId(HttpServletResponse response,@RequestParam Integer postId) throws IOException {
        List<Likes> likes = postService.findLikesByPostId(postId);
        setEncoding(response);
        String json = gson.toJson(likes);
        response.getWriter().write(json);
    }
    @RequestMapping(value = "/findPostLikes",method = RequestMethod.GET)
    public void findLikeForPost(HttpServletResponse response,@RequestParam Integer postId) throws IOException {
        Integer result = postService.findLikeForPost(postId);
        setEncoding(response);
        String json = gson.toJson(result);
        response.getWriter().write(json);
    }
    @RequestMapping(value = "/findRepostCount",method = RequestMethod.GET)
    public void findRepostForPost(@RequestParam Integer postId,HttpServletResponse response) throws IOException {
        Integer result = postService.findRepostForPost(postId);
        setEncoding(response);
        String json = gson.toJson(result);
        response.getWriter().write(json);
    }
}

