package wang.redbean.blog.article.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.article.entity.ArticleCategory;
import wang.redbean.blog.article.mapper.ArticleCategoryMapper;
import wang.redbean.blog.article.serivce.IArticleCategoryService;

/**
 * 文章类目业务实现类
 */
@Service
public class ArticleCategoryServiceImpl extends ServiceImpl<ArticleCategoryMapper, ArticleCategory> implements IArticleCategoryService {
}
