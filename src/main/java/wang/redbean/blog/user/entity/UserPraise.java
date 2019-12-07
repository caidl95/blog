package wang.redbean.blog.user.entity;

import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

/**
 * 用户点赞实体类
 */
@Data
public class UserPraise extends BaseEntity {

    private Integer praiseId;//点赞表id

    private Integer userId;//用户ID

    private Integer praiseArticleId;//点赞文章的ID

    private Integer praiseStatus;//点赞状态，0正常1取消
}
