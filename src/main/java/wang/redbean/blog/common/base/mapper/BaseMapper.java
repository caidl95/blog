package wang.redbean.blog.common.base.mapper;


import wang.redbean.blog.common.base.entity.BaseEntity;

/**
 * Mapper基类
 */
public interface BaseMapper<T extends BaseEntity> {

	/**
	 * 新增entity
	 */
	Integer insert(T entity);

	/**
	 * 动态新增entity
	 */
	Integer insertSelective(T entity);

	/**
	 * 根据entityId删除记录
	 */
	Integer deleteByPrimaryKey(Integer id);

	/**
	 * 更新entity
	 */
	Integer updateByPrimaryKey(T entity);

	/**
	 * 动态更新entity
	 */
	Integer updateByPrimaryKeySelective(T entity);

	/**
	 * 根据entityId查询
	 */
	T selectByPrimaryKey(Integer id);


}
