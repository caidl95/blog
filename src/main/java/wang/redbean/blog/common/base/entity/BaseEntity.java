package wang.redbean.blog.common.base.entity;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * Entity基类
 */
public abstract class BaseEntity implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 5627921366102901306L;

	/**
	 * 	操作者
	 */
	protected Data createTime;

	/**
	 * 操作时间
	 */
	protected Date updateTime;


	public BaseEntity() {}

	public BaseEntity(Data createTime, Date updateTime) {
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Data getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Data createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
