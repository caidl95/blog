package wang.redbean.blog.user.entity.vo;

import lombok.Data;
import wang.redbean.blog.user.entity.UserAttention;

@Data
public class UserAttentionVo extends UserAttention {

    private String userName;

    private String userIcon;

}
