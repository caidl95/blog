package wang.redbean.blog.core.base.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * Entity基类
 */
@Data
public abstract class BaseEntity implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 5627921366102901306L;

	/**
	 * 	操作者
	 */
	protected Date createTime;

	/**
	 * 操作时间
	 */
	protected Date updateTime;


}
