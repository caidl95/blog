package wang.redbean.blog.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import wang.redbean.blog.article.entity.ArticleCategory;
import wang.redbean.blog.article.serivce.impl.ArticleCategoryServiceImpl;
import wang.redbean.blog.common.base.entity.response.ServerResponse;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Tools {

    /**
     * 字符串转日期格式
     * @param str
     * @return
     */
    public static Date StringToDate(String str){
        Date date = null;
        if(!StringUtils.isBlank(str)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = sdf.parse(str);
            }catch (ParseException e){
                e.printStackTrace();
            }
        }
        return date;
    }

    public static boolean IsTypeExist(Integer type, ArticleCategoryServiceImpl articleCategoryService){
        boolean result = false;
        ArticleCategory entity = new ArticleCategory();
        entity.setCategoryType(type);
        List<ArticleCategory> articleCategoryList = articleCategoryService.getByParam(entity);//根据类目类型从数据库查询数据
        if(articleCategoryList.size()>0){//该类型在数据库已存在
            result = true;
        }
        return  result;
    }

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
