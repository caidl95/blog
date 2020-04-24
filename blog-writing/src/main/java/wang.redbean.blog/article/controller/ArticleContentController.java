package wang.redbean.blog.article.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.article.model.entity.ArticleContent;
import wang.redbean.blog.article.serivce.IArticleContentService;
import wang.redbean.blog.base.controller.BaseController;
import wang.redbean.blog.base.entity.response.ServerResponse;

@RestController
@RequestMapping("/article/content")
@Api("文章内容控制器类")
public class ArticleContentController extends BaseController<IArticleContentService, ArticleContent> {

    @PostMapping("/update")
    public ServerResponse update(ArticleContent articleContent){
        return ServerResponse.isSuccess(baseService.updateByArticleId(articleContent));
    }

    @GetMapping("get")
    public ServerResponse get(Integer articleId){
        ArticleContent articleContent = baseService.getByArticleId(articleId);
        if(articleContent.getArticleId() == articleId){
            return ServerResponse.success("查询成功",articleContent);
        }else{
            return ServerResponse.error("查询失败");
        }
    }
}
