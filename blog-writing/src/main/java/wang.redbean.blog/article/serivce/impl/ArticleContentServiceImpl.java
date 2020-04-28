package wang.redbean.blog.article.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.article.mapper.ArticleContentMapper;
import wang.redbean.blog.article.model.entity.ArticleContent;
import wang.redbean.blog.article.serivce.IArticleContentService;
import wang.redbean.blog.utils.ValidationUtil;

/**
 * 文章内容业务实现类
 */
@Service
public class ArticleContentServiceImpl extends ServiceImpl<ArticleContentMapper, ArticleContent> implements IArticleContentService {

    /**
     * 根据文章id修改文章正文
     */
    @Override
    public boolean updateByArticleId(ArticleContent articleContent) {
        return ValidationUtil.retBool( baseMapper.update(articleContent,new QueryWrapper<ArticleContent>().lambda().eq(ArticleContent::getArticleId,articleContent.getArticleId())));
    }

    /**
     * 根据文章id查询文章正文
     */
    @Override
    public ArticleContent getByArticleId(Long articleId) {
        return baseMapper.selectOne(new QueryWrapper<ArticleContent>().lambda().eq(ArticleContent::getArticleId,articleId));
    }
}
