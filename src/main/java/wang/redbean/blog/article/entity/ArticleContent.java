package wang.redbean.blog.article.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

/**
 * 文章内容实体类
 */
@Data
@TableName("article_content")
public class ArticleContent extends BaseEntity {

    @TableId(value = "content_id" , type = IdType.AUTO)
    private Integer contentId;//正文ID

    private Integer articleId;//文章ID

    private String contentBody;//文章正文

}
