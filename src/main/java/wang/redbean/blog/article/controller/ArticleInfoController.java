package wang.redbean.blog.article.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.article.serivce.IArticleInfoService;
import wang.redbean.blog.common.base.controller.BaseController;

/**
 * 章详情控制器类
 */
@RestController
@RequestMapping("/article_info")
public class ArticleInfoController extends BaseController<IArticleInfoService> {
}
