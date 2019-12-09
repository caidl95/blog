package wang.redbean.blog.article.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.redbean.blog.article.entity.ArticleCategory;
import wang.redbean.blog.article.mapper.ArticleCategoryMapper;
import wang.redbean.blog.article.serivce.IArticleCategoryService;

/**
 * 文章类目业务实现类
 */
@Service
public class ArticleCategoryServiceImpl extends ServiceImpl<ArticleCategoryMapper, ArticleCategory> implements IArticleCategoryService {


    @Override
    public boolean save(ArticleCategory entity) {
        return super.save(entity);
    }
}
