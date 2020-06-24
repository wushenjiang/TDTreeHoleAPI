package com.liuge.controller;

import com.google.gson.Gson;
import com.liuge.domain.Repost;
import com.liuge.service.RepostService;
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
 * @ClassName: RepostController
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/24  17:41
 */
@Controller
@RequestMapping("/repost")
public class RepostController {

    private Gson gson = new Gson();

    private void setEncoding(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }
    @Autowired
    RepostService repostService;
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public void findAll(HttpServletResponse response, @RequestParam int postId) throws IOException {
        setEncoding(response);
        List<Repost> reposts = repostService.findAll(postId);
        String jsonStr = gson.toJson(reposts);
        response.getWriter().write(jsonStr);
    }
    @RequestMapping(value = "/repost",method = RequestMethod.POST)
    public void addRepost(HttpServletResponse response,@RequestBody Repost repost) throws  IOException{
        setEncoding(response);
        int result = repostService.addRepost(repost);
        String jsonStr = gson.toJson(result);
        response.getWriter().write(jsonStr);
    }

}
