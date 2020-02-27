package wang.redbean.blog.article.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.article.entity.ArticleContent;
import wang.redbean.blog.article.serivce.IArticleContentService;
import wang.redbean.blog.core.base.controller.BaseController;
import wang.redbean.blog.core.base.model.response.ServerResponse;

/**
 * 文章内容控制器类
 */
@RestController
@RequestMapping("/article/content")
public class ArticleContentController extends BaseController<IArticleContentService> {

    @PostMapping("/update")
    public ServerResponse update(ArticleContent articleContent){
        Integer result = service.updateByArticleId(articleContent);
        if(result>0){
            return  ServerResponse.createBySuccessMessage("更新成功");
        }else{
            return  ServerResponse.createByErrorMessage("更新失败");
        }
    }

    @GetMapping("get")
    public ServerResponse get(Integer articleId){
        ArticleContent articleContent = service.getByArticleId(articleId);
        if(articleContent.getArticleId() == articleId){
            return ServerResponse.createBySuccess("查询成功",articleContent);
        }else{
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }
}
