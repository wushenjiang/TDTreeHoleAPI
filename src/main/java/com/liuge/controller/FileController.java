package com.liuge.controller;

import com.google.gson.Gson;
import org.omg.CORBA.portable.OutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import sun.security.krb5.internal.PAData;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * @ClassName: FileController
 * @Description: TODO
 * @author: LiuGe
 * @date: 2020/5/26  10:13
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/upload")
    public void uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/user_image/");
        //获取上传文件的名称
        String filename = file.getOriginalFilename();
        //判断该路径是否存在
        File file_temp = new File(path);
        if(!file_temp.exists()){
            //创建该文件夹
            file_temp.mkdirs();
        }
        filename =  "user_"+filename;
        //上传文件
        file.transferTo(new File(path,filename));
        Gson gson = new Gson();
        String json = gson.toJson(path+filename);
        //将路径打印出来
        response.getWriter().write(json);
    }
    @RequestMapping("/download")
    public void downloadFile(HttpServletResponse response,@RequestParam("path") String path,HttpServletRequest request) throws IOException {
        String filename = path.substring(path.lastIndexOf("/")+1);
        String filePath = request.getSession().getServletContext().getRealPath("/")+path;
        System.out.println(filePath);
        InputStream fis = new BufferedInputStream(new FileInputStream(filePath));
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition","attachment;filename="+filename);
        BufferedOutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        toClient.write(buffer);
        toClient.flush();
        toClient.close();


    }
}
