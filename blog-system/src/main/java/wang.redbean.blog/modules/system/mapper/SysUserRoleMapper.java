package wang.redbean.blog.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wang.redbean.blog.modules.system.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 用户与角色关系DAO
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {
	
}
