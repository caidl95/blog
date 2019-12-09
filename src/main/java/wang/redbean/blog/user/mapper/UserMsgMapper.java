package wang.redbean.blog.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import wang.redbean.blog.user.entity.UserMsg;

/**
 * 用户信息映射接口类
 */
public interface UserMsgMapper extends BaseMapper<UserMsg> {

    @Select("checkUserName")
    Integer checkUserName(String userName);

}
