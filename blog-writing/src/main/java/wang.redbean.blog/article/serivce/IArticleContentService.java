package wang.redbean.blog.article.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import wang.redbean.blog.article.model.entity.ArticleContent;

/**
 * 文章内容业务接口类
 */
public interface IArticleContentService extends IService<ArticleContent> {

    boolean updateByArticleId(ArticleContent articleContent);

    ArticleContent getByArticleId(Long articleId);

}
