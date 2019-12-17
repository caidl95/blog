package wang.redbean.blog.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import wang.redbean.blog.user.entity.UserMsg;
import wang.redbean.blog.user.entity.vo.UserMsgVo;

/**
 * 用户信息映射接口类
 */
public interface UserMsgMapper extends BaseMapper<UserMsg> {

    Integer checkUserName(String userName);

    Integer checkUserPhone(String userPhone);

    Integer checkUserEmail(String userEmail);

    UserMsgVo selectLogin(@Param("userName") String userName, @Param("userPassword") String userPassword);

    Integer checkUserPassword(@Param("userPassword") String userPassword, @Param("userId") Integer userId);

    Integer updateUserPassword(@Param("userId") Integer userId, @Param("userPassword") String userPassword);


}
