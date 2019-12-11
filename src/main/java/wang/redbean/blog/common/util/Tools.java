package wang.redbean.blog.common.util;

import org.apache.commons.lang3.StringUtils;
import wang.redbean.blog.article.entity.ArticleCategory;
import wang.redbean.blog.article.serivce.impl.ArticleCategoryServiceImpl;
import wang.redbean.blog.common.base.entity.response.ServerResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
}
