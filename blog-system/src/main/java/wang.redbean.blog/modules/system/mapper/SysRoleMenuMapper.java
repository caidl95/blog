package wang.redbean.blog.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wang.redbean.blog.modules.system.entity.SysRoleMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色权限关系DAO
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuEntity> {
	
}
