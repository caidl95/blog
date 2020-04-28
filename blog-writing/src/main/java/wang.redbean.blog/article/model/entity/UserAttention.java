package wang.redbean.blog.article.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import wang.redbean.blog.base.entity.BaseEntity;

/**
 * 用户关注实体类
 */
@Getter
@Setter
@TableName("user_attention")
public class UserAttention extends BaseEntity {

    @TableField("username")
    protected String username;//用户

    @TableField("attention_user_id")
    protected Integer attentionUserId;//关注的ID

    @TableField("status")
    protected Integer status = 0;//关注状态，0正常1取消

}
