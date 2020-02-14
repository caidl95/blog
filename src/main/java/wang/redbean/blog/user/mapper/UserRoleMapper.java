package wang.redbean.blog.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wang.redbean.blog.user.model.UserRole;

public interface UserRoleMapper extends BaseMapper<UserRole> {

    Integer deleteByUserId(Integer userId);

}
