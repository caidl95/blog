package wang.redbean.blog.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity基类
 */
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 5627921366102901306L;

	@ApiParam(name="id",value="ID")
	@TableId(value = "id",type = IdType.AUTO)
	protected Long id;

	@ApiParam(name="createTime",value="创建时间")
	@TableField("create_time")
	protected Date createTime;

	@ApiParam(name="updateTime",value="修改时间")
	@TableField("update_time")
	protected Date updateTime;

	public BaseEntity() {
	}

	public BaseEntity(Long id) {
		this.id = id;
	}


}
