package wang.redbean.blog.common.util;

import org.springframework.web.multipart.MultipartFile;
import wang.redbean.blog.common.base.exception.BaseException;

import java.io.*;
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
            throw new BaseException( "文件为空");
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

    /**
     * 下载功能
     * @param path 需要下载的文件地址
     * @return 返回byte数组
     */
    public static byte[] download(String path){
        File file = new File(path);
        byte[] data =new byte[(int)file.length()];
        try (InputStream in = new FileInputStream(file)){
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[(int)file.length()];
            int n;
            while ((n = in.read(buffer)) != -1) {
                out.write( buffer, 0, n);
            }
            data =  out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }


    /**
     * 根据路径删除文件
     * @param path 路径
     */
    public static boolean deleteFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        } else {
            String[] filenames = file.list();
            for (String f : filenames) {
                deleteFile(f);
            }
            return file.delete();
        }
    }




}
