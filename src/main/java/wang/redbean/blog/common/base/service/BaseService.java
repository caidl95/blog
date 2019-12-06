package wang.redbean.blog.common.base.service;

import wang.redbean.blog.common.base.entity.BaseEntity;
import wang.redbean.blog.common.base.entity.response.ServerResponse;

/**
 * Service公共接口
 */
public interface BaseService<T extends BaseEntity> {

	/**
	 * 新增entity
	 */
	ServerResponse insert(T entity);

	/**
	 * 动态新增entity
	 */
	ServerResponse insertSelective(T entity);

	/**
	 * 根据entityId删除记录
	 */
	ServerResponse deleteByPrimaryKey(Integer entityId);

	/**
	 * 更新entity
	 */
	ServerResponse updateByPrimaryKey(T entity);

	/**
	 * 动态更新entity
	 */
	ServerResponse updateByPrimaryKeySelective(T entity);

	/**
	 * 根据entityId查询
	 */
	ServerResponse<T> selectByPrimaryKey(Integer entityId);

}
