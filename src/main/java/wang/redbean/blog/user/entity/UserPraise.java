package wang.redbean.blog.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

/**
 * 用户点赞实体类
 */
@Data
@TableName(value = "user_praise")
public class UserPraise extends BaseEntity {

    @TableId(value = "praise_id",type = IdType.AUTO)
    private Integer praiseId;//点赞表id

    private Integer userId;//用户ID

    private Integer praiseArticleId;//点赞文章的ID

    private Integer praiseStatus;//点赞状态，0正常1取消
}
