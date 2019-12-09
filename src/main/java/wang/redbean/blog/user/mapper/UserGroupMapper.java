package wang.redbean.blog.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import wang.redbean.blog.user.entity.UserGroup;
import wang.redbean.blog.user.entity.vo.UserGroupVo;

import java.util.List;

/**
 * 权限映射接口类
 */
public interface UserGroupMapper extends BaseMapper<UserGroup> {

    @Select("selectByUserId")
    List<UserGroupVo> selectByUserId(Integer userId);

}
