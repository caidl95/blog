package wang.redbean.blog.article.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.article.serivce.IArticleCategoryService;
import wang.redbean.blog.common.base.controller.BaseController;

/**
 * 文章类目控制器类
 */
@RestController
@RequestMapping("/article_category")
public class ArticleCategoryController extends BaseController<IArticleCategoryService> {
}
