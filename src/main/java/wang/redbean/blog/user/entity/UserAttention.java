package wang.redbean.blog.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.core.base.entity.BaseEntity;

/**
 * 用户关注实体类
 */
@Data
@TableName("user_attention")
public class UserAttention extends BaseEntity {

    @TableId(value = "attention_id" , type = IdType.AUTO)
    private Integer attentionId;//关注表id

    private Integer userId;//用户ID

    private Integer attentionUserId;//关注的ID

    private Integer attentionStatus;//关注状态，0正常1取消

}
