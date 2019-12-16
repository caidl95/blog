package wang.redbean.blog.article.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.article.entity.ArticleContent;
import wang.redbean.blog.article.mapper.ArticleContentMapper;
import wang.redbean.blog.article.serivce.IArticleContentService;

/**
 * 文章内容业务实现类
 */
@Service
public class ArticleContentServiceImpl extends ServiceImpl<ArticleContentMapper, ArticleContent> implements IArticleContentService {

    /**
     * 根据文章id修改文章正文
     * @param articleContent
     * @return
     */
    @Override
    public Integer updateByArticleId(ArticleContent articleContent) {
        Integer result = baseMapper.updateByArticleId(articleContent);
        return result;
    }

    /**
     * 根据文章id查询文章正文
     * @param articleId
     * @return
     */
    @Override
    public ArticleContent getByArticleId(Integer articleId) {
        ArticleContent articleContent = baseMapper.getByArticleId(articleId);
        return articleContent;
    }
}
