package wang.redbean.blog.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import wang.redbean.blog.article.entity.ArticleContent;

/**
 * 文章内容映射接口类
 */
public interface ArticleContentMapper extends BaseMapper<ArticleContent> {

    Integer updateByArticleId(@Param("articleContent") ArticleContent articleContent);

    ArticleContent getByArticleId(@Param("articleId") Integer articleId);

}
