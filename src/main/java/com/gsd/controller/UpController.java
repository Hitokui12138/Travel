package com.gsd.controller;

import com.gsd.util.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UpController.java
 * @Description TODO
 * @createTime 2023年09月12日 13:30:00
 */
@Controller
public class UpController {
    /**
     * 客户端和服务器两部分
     * A. 客户端
     *     1.表单必须是POST,否则只有文件名
     *     2.请求类型必须是,multipart/form-data,以流的方式上传
     *
     * B. 服务端
     *  MultipartFile,MultipartFile需要把物理文件解析成一个对象
     *  1. 注册文件上传解析处理器(没有处理MultipartFile的配置) SpringMVC.xml
     *  2. 解析处理器本身还需要两个JAR包,导一个有依赖的就行
     *
     *
     * @param file
     * @return
     */
    @PostMapping("up")
    public String up(MultipartFile file, HttpServletRequest request) throws IOException {

        String fileName = FileUtils.up(file, request);
        System.out.println(fileName);

        return "index";
    }
}
