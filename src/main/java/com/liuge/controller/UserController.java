package com.liuge.controller;

import com.google.gson.Gson;
import com.liuge.domain.Post;
import com.liuge.domain.Repost;
import com.liuge.domain.User;
import com.liuge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/24  18:29
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Gson gson = new Gson();

    private void setEncoding(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }
    @Autowired
    UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(@RequestBody  User user, HttpServletResponse response) throws IOException {
        setEncoding(response);
        Integer result = userService.login(user);
        String jsonStr = gson.toJson(result);
        response.getWriter().print(jsonStr);
    }
    @RequestMapping(value = "/findPost",method = RequestMethod.GET)
    public void findPostById(@RequestParam Integer userId,HttpServletResponse response) throws IOException {
        setEncoding(response);
        List<Post> posts = userService.findPostById(userId);
        String jsonStr = gson.toJson(posts);
        response.getWriter().print(jsonStr);
    }
    @RequestMapping(value = "/findRepost",method = RequestMethod.GET)
    public void findRepostById(@RequestParam Integer userId,HttpServletResponse response) throws IOException{
        setEncoding(response);
        List<Repost> reposts = userService.findRepostById(userId);
        String jsonStr = gson.toJson(reposts);
        response.getWriter().write(jsonStr);
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void register(@RequestBody User user,HttpServletResponse response) throws IOException {
        setEncoding(response);
        Integer result = userService.register(user);
        String json = gson.toJson(result);
        response.getWriter().write(json);
    }
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public void updateUser(@RequestBody User user,HttpServletResponse response) throws IOException {
        setEncoding(response);
        Integer result = userService.updateUser(user);
        String json = gson.toJson(result);
        response.getWriter().write(json);
    }
}
