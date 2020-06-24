package com.liuge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: SpringTest
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/24  14:15
 */
@Controller
@RequestMapping(value = "/test",method = RequestMethod.POST)
public class SpringTest {
    @RequestMapping("/test")
    public void test(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("卧槽");
    }
}
