package wang.redbean.blog.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import wang.redbean.blog.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;


/**
 * @Description 角色与权限关系实体
 */
@Getter
@Setter
@TableName("sys_role_menu")
public class SysRoleMenuEntity extends BaseEntity {

	/**
	 * 角色ID
	 */
	@TableField("role_id")
	private Long roleId;

	/**
	 * 权限ID
	 */
	@TableField("menu_id")
	private Long menuId;
}
