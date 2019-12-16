package wang.redbean.blog.article.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import wang.redbean.blog.article.entity.ArticleContent;

/**
 * 文章内容业务接口类
 */
public interface IArticleContentService extends IService<ArticleContent> {

    Integer updateByArticleId(ArticleContent articleContent);

    ArticleContent getByArticleId(Integer articleId);

}
