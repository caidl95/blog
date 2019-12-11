package wang.redbean.blog.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.article.entity.ArticleCategory;
import wang.redbean.blog.article.entity.vo.ResultVo;
import wang.redbean.blog.article.serivce.IArticleCategoryService;
import wang.redbean.blog.article.serivce.impl.ArticleCategoryServiceImpl;
import wang.redbean.blog.common.base.controller.BaseController;
import wang.redbean.blog.utils.ResultVoUtil;

import javax.servlet.http.HttpSession;
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
    public ResultVo save(ArticleCategory articleCategory){
        boolean result = articleCategoryService.save(articleCategory);
        if(result){
            return ResultVoUtil.success();
        }else{
            return ResultVoUtil.error(400,"保存失败");
        }
    }

    @GetMapping("/delete")
    public ResultVo delete(List<Integer> idList){
        Integer result = articleCategoryService.deleteByIds(idList);
        if(result>0){
            return ResultVoUtil.success(result);//result，返回删除行数
        }else{
            return ResultVoUtil.error(400,"删除失败");
        }
    }

    @PostMapping("update")
    public ResultVo update(ArticleCategory articleCategory){
        boolean result = articleCategoryService.updateById(articleCategory);
        if(result){
            return ResultVoUtil.success();
        }else{
            return ResultVoUtil.error(400,"修改失败");
        }
    }


}
