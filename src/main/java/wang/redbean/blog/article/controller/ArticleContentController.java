package wang.redbean.blog.article.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.article.serivce.IArticleContentService;
import wang.redbean.blog.common.base.controller.BaseController;

/**
 * 文章内容控制器类
 */
@RestController
@RequestMapping("/article_content")
public class ArticleContentController extends BaseController<IArticleContentService> {
}
