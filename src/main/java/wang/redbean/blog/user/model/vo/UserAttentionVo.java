package wang.redbean.blog.user.model.vo;

import lombok.Data;
import wang.redbean.blog.user.model.UserAttention;

@Data
public class UserAttentionVo extends UserAttention {

    private String userName;

    private String userIcon;

}
