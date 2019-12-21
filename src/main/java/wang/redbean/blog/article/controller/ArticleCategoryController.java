package wang.redbean.blog.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wang.redbean.blog.article.entity.ArticleCategory;
import wang.redbean.blog.article.entity.param.ArticleCategoryParam;
import wang.redbean.blog.article.serivce.IArticleCategoryService;
import wang.redbean.blog.article.serivce.impl.ArticleCategoryServiceImpl;
import wang.redbean.blog.core.base.controller.BaseController;
import wang.redbean.blog.core.base.entity.response.ServerResponse;
import wang.redbean.blog.core.util.Tools;

import java.util.List;

/**
 * 文章类目控制器类
 */
@RestController
@RequestMapping("/article/category")
public class ArticleCategoryController extends BaseController<IArticleCategoryService> {

    @Autowired
    private ArticleCategoryServiceImpl articleCategoryService;

    @PostMapping("/save")
    public ServerResponse save(ArticleCategory articleCategory){
        if(Tools.IsTypeExist(articleCategory.getCategoryType(),articleCategoryService)){
            return ServerResponse.createByErrorMessage("保存失败,该类目类型已存在");
        }else{
            boolean result = articleCategoryService.save(articleCategory);
            if(result){
                return ServerResponse.createBySuccessMessage("保存成功");
            }else{
                return ServerResponse.createByErrorMessage("保存失败");
            }
        }

    }

    @GetMapping("/delete")
    public ServerResponse delete(@RequestParam(value = "idList",required = true) List<Integer> idList){
        Integer result = articleCategoryService.deleteByIds(idList);
        if(result>0){
            return ServerResponse.createBySuccess("删除成功",result);//result，返回删除行数
        }else{
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }

    @PostMapping("/update")
    public ServerResponse update(ArticleCategory articleCategory){
        if(Tools.IsTypeExist(articleCategory.getCategoryType(),articleCategoryService)){
            return ServerResponse.createByErrorMessage("修改失败,该类目类型已存在");
        }else{
            boolean result = articleCategoryService.updateById(articleCategory);
            if(result){
                return ServerResponse.createByErrorMessage("修改成功");
            }else{
                return ServerResponse.createByErrorMessage("修改失败");
            }
        }

    }

    @GetMapping("/get")
    public ServerResponse get(ArticleCategoryParam articleCategoryParam){
       return ServerResponse.createBySuccess(articleCategoryService.getByParam(articleCategoryParam));
    }

}
