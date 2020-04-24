package wang.redbean.blog.article.model.vo;

import lombok.Getter;
import lombok.Setter;
import wang.redbean.blog.article.model.entity.UserAttention;

@Getter
@Setter
public class UserAttentionVo extends UserAttention {

    private String userName;

    private String userIcon;

}
