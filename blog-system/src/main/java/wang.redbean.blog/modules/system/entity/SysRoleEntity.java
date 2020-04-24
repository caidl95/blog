package wang.redbean.blog.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import wang.redbean.blog.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;


/**
 * @Description 角色实体
 */
@Getter
@Setter
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity {

	/**
	 * 角色名称
	 */
	@TableField("role_name")
	private String roleName;
}
