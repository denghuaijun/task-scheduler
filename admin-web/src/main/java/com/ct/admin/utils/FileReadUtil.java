package com.ct.admin.utils;

import com.ct.admin.model.MarkdownEntity;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 读取本地文件工具类
 * @author itw_denghj
 * @时间 2019/2/20
 */
public class FileReadUtil {

    public static InputStream getStreamByFileName(String fileName)throws IOException{
        if (fileName.startsWith("http")){
            URL url = new URL(fileName);
            return url.openStream();
        }else if (fileName.startsWith("/")){
            Path path = Paths.get(fileName);
            return  FileReadUtil.class.getClassLoader().getResourceAsStream(fileName);
        }else {
            return FileReadUtil.class.getClassLoader().getResourceAsStream(fileName);
        }
    }

    public static String readFileContent(String fileName)throws IOException{
        String path = FileReadUtil.class.getClassLoader().getResource(".").getPath();
        return FileUtils.readFileToString(new File(path+"/"+fileName));
    }

    public static void main(String[] args) throws IOException {
        System.out.println("/E:/task_scheduler/admin-web/target/classes/==:"+FileReadUtil.class.getClassLoader().getResource(".").getPath());
        String path = FileReadUtil.class.getClassLoader().getResource(".").getPath();
        String file = "md/helper.md";
        System.out.println("test==:"+ FileReadUtil.readFileContent(file));
        MarkdownEntity markdownEntity = MarkDown2HtmlWrapper.ofFile(file);
        System.out.println("html==:"+markdownEntity.toString());
    }
}
