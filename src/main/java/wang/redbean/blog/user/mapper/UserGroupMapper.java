package wang.redbean.blog.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import wang.redbean.blog.user.entity.UserGroup;
import wang.redbean.blog.user.entity.vo.UserGroupVo;

import java.util.List;

/**
 * 权限映射接口类
 */
public interface UserGroupMapper extends BaseMapper<UserGroup> {

    List<UserGroupVo> selectByUserId(Integer userId);

    Integer deleteByUserIdAndRightsType(@Param("userId") int userId, @Param("rightsType") Integer rightsType);

    Integer insert( @Param("userGroups") List<UserGroup> userGroups);
}
