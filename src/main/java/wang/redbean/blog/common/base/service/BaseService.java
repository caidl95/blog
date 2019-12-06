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
	void insert(T entity);

	/**
	 * 动态新增entity
	 */
	void insertSelective(T entity);

	/**
	 * 根据entityId删除记录
	 */
	void deleteByPrimaryKey(Integer entityId);

	/**
	 * 更新entity
	 */
	void updateByPrimaryKey(T entity);

	/**
	 * 动态更新entity
	 */
	void updateByPrimaryKeySelective(T entity);

	/**
	 * 根据entityId查询
	 */
	T selectByPrimaryKey(Integer entityId);

}
