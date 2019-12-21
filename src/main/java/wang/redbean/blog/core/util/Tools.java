package wang.redbean.blog.core.util;

import wang.redbean.blog.article.entity.ArticleCategory;
import wang.redbean.blog.article.entity.param.ArticleCategoryParam;
import wang.redbean.blog.article.serivce.impl.ArticleCategoryServiceImpl;

import java.util.List;

public class Tools {

    public static boolean IsTypeExist(Integer type, ArticleCategoryServiceImpl articleCategoryService){
        boolean result = false;
        ArticleCategoryParam entity = new ArticleCategoryParam();
        entity.setCategoryType(type);
        List<ArticleCategory> articleCategoryList = articleCategoryService.getByParam(entity);//根据类目类型从数据库查询数据
        if(articleCategoryList.size()>0){//该类型在数据库已存在
            result = true;
        }
        return  result;
    }
}
