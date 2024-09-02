package com.gsd.util;

import org.apache.commons.io.FilenameUtils;
import org.joda.time.DateTime;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName FileUtils.java
 * @Description TODO
 * @createTime 2023年09月12日 14:34:00
 */
public class FileUtils {

    /**
     * 同步上传,
     * data是个JSON串,不能异步上传
     *
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    public static String up(MultipartFile file, HttpServletRequest request) throws IOException {

        if(file.isEmpty()) return null;
        //不能直接右键建文件夹
        String uploadPath = request.getRealPath("upload/");//获取服务器路径,路径可以先不存在

        //如果所有文件放到一个文件夹下,IO会很慢,让目录变成一个 时间戳的目录
        //可以借助日期工具类去写 joda-time 导入
        String datePath = new DateTime().toString("yyyy/MM/dd/HH");
        uploadPath = uploadPath + datePath;

        //为了避免文件名重复导致源文件被覆盖
        //UUID 生成唯一文件,20万
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuid);//随机字符串

        //取得后缀名,使用导入的工具类,但注意这个不带"."
        String originalFilename =file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFilename);

        File uploadFile = new File(uploadPath);
        if(!uploadFile.exists()){
            uploadFile.mkdirs();
        }

        //复制文件到这个路径, temp->upload
        file.transferTo(new File(uploadFile,uuid +'.'+extension));

        return "upload/"+datePath +'/'+ uuid +'.'+extension;
    }

    /**
     * 异步上传
     */


}
