package wang.redbean.blog.article.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import wang.redbean.blog.base.entity.BaseEntity;

/**
 * 用户评论实体类
 */
@Getter
@Setter
@TableName("user_comment")
public class UserComment extends BaseEntity {

    @TableField("comment_content")
    private String commentContent;//评论内容

    @TableField("article_id")
    private Integer articleId;//文章ID

    @TableField("username")
    private String username;//用户

    @TableField("status")
    private Integer status;//评论状态，0正常1作废
}
