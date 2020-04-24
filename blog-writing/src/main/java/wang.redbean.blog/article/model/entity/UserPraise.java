package wang.redbean.blog.article.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import wang.redbean.blog.base.entity.BaseEntity;

/**
 * 用户点赞实体类
 */
@Getter
@Setter
@TableName(value = "user_praise")
public class UserPraise extends BaseEntity {

    @TableField("username")
    private String username;//用户

    @TableField("praise_article_id")
    private Integer praiseArticleId;//点赞文章的ID

    @TableField("status")
    private Integer status;//点赞状态，0正常1取消
}
