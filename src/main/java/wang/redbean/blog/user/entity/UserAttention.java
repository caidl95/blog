package wang.redbean.blog.user.entity;

import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

/**
 * 用户关注实体类
 */
@Data
public class UserAttention extends BaseEntity {

    private Integer attentionId;//关注表id

    private Integer userId;//用户ID

    private Integer attentionUserId;//关注的ID

    private Integer attentionStatus;//关注状态，0正常1取消


}
