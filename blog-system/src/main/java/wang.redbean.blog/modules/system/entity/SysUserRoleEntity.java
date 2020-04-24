package wang.redbean.blog.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import wang.redbean.blog.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;


/**
 * @Description 用户与角色关系实体
 */
@Getter
@Setter
@TableName("sys_user_role")
public class SysUserRoleEntity extends BaseEntity {

	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 角色ID
	 */
	private Long roleId;

	public SysUserRoleEntity() {

	}

	public SysUserRoleEntity(Long id) {
		super(id);
	}
}
