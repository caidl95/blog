package wang.redbean.blog.common.util;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FileUtil {


    /**
     * 上传图片功能
     * @param file 图片文件
     * @param rootPath 文件保存的根目录
     * @param startName 保存的文件名的开头
     * @return
     */
    public static String uploadPic(MultipartFile file,String rootPath,String startName){
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = rootPath+new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString()+"//"; // 上传后的路径
        fileName = startName+"-"+ UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().setWritable(true);//给予权限
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath+fileName;
    }
}
