package wang.redbean.blog.user.entity;

import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

/**
 * 用户评论实体类
 */
@Data
public class UserComment extends BaseEntity {

    private Integer commentId;//评论ID

    private String commentContent;//评论内容

    private Integer articleId;//文章ID

    private Integer userId;//用户ID

    private Integer commentStatus;//评论状态，0正常1作废
}
