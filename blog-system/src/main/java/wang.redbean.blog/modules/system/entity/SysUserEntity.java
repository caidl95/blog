package wang.redbean.blog.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import wang.redbean.blog.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 系统用户实体
 */
@Getter
@Setter
@ToString
@TableName("sys_user")
public class SysUserEntity extends BaseEntity {

	@TableField("username")
	private String username;//用户名

	@TableField("password")
	private String password;//密码

	@TableField("nickname")
	private String nickname;//用户昵称

	@TableField("sex")
	private String sex;//用户性别

	@TableField("email")
	private String email;//用户邮箱

	@TableField("phone")
	private String phone;//用户手机号

	@TableField("icon")
	private String icon;//用户头像图片

	@TableField("status")
	private String status;//状态:NORMAL正常  PROHIBIT禁用

}