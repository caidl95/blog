package wang.redbean.blog.article.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import wang.redbean.blog.base.entity.BaseEntity;

/**
 * 文章内容实体类
 */
@Getter
@Setter
@TableName("article_content")
public class ArticleContent extends BaseEntity {

    @TableField("article_id")
    private Integer articleId;//文章ID

    @TableField("content_body")
    private String contentBody;//文章正文

}
