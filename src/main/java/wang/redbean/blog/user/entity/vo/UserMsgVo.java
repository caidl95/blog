package wang.redbean.blog.user.entity.vo;

import lombok.Data;
import wang.redbean.blog.user.entity.UserMsg;

import java.util.List;

@Data
public class UserMsgVo extends UserMsg {

    private List<UserGroupVo> userGroupVoList;

}
