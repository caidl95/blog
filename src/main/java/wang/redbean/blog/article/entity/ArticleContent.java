package wang.redbean.blog.article.entity;

import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

/**
 * 文章内容实体类
 */
@Data
public class ArticleContent extends BaseEntity {

    private Integer contentId;//正文ID

    private Integer articleId;//文章ID

    private String contentBody;//文章正文

}
