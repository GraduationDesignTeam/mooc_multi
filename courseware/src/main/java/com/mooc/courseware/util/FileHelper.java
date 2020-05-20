package com.mooc.courseware.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class FileHelper {

    public static String upload(String directoryPath, MultipartFile file){
        //原文件名
        String originalName = file.getOriginalFilename();
        String newName;
        if(originalName!=null && originalName.lastIndexOf(".")!=-1){
            //取扩展名
            String ext = originalName.substring(originalName.lastIndexOf("."));
            //构造新文件名
            newName = UUID.randomUUID() + ext;
        }else
            newName = UUID.randomUUID().toString();

        //复制到映射的地址
        FileOutputStream fileOutputStream = null;
        try {
            //目标地址构造成输出流
            fileOutputStream = new FileOutputStream(directoryPath + newName);
            //复制文件
            FileCopyUtils.copy(file.getInputStream(),fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newName;
    }

    public static void delete(String directoryPath, String fileName){
        File file = new File(directoryPath+fileName);
        if(file.exists())
            file.delete();
    }

    /**
     * 加载文件
     * @param fileName 文件名
     * @return 文件
     */
    public static Resource loadFileAsResource(String directoryPath, String fileName) {
        try {
            Path filePath = Paths.get(directoryPath+fileName);
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists())
                return resource;
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
