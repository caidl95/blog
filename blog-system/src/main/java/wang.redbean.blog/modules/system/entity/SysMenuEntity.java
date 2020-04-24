package wang.redbean.blog.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import wang.redbean.blog.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;


/**
 * @Description 权限实体
 */
@Getter
@Setter
@TableName("sys_menu")
public class SysMenuEntity extends BaseEntity {


	/**
	 * 权限名称
	 */
	@TableField("name")
	private String name;
	/**
	 * 权限标识
	 */
	@TableField("permission")
	private String permission;

}
