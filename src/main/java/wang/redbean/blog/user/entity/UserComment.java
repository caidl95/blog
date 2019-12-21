package wang.redbean.blog.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.core.base.entity.BaseEntity;

/**
 * 用户评论实体类
 */
@Data
@TableName("user_comment")
public class UserComment extends BaseEntity {

    @TableId(value = "comment_id" , type = IdType.AUTO)
    private Integer commentId;//评论ID

    private String commentContent;//评论内容

    private Integer articleId;//文章ID

    private Integer userId;//用户ID

    private Integer commentStatus;//评论状态，0正常1作废
}
