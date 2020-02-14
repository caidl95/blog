package wang.redbean.blog.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wang.redbean.blog.user.model.UserMsg;

/**
 * 用户信息映射接口类
 */
public interface UserMsgMapper extends BaseMapper<UserMsg> {

    UserMsg selectByUserId(Integer userId);




}
