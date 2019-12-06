package wang.redbean.blog.common.base.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import wang.redbean.blog.common.base.entity.BaseEntity;
import wang.redbean.blog.common.base.exception.BaseException;
import wang.redbean.blog.common.base.mapper.BaseMapper;

/**
 * Service抽象类
 */
public abstract class AbstractService<T extends BaseEntity, D extends BaseMapper<T>> implements BaseService<T> {

	/**
	 * 业务日志记录
	 */
	protected static Logger log = Logger.getLogger(AbstractService.class);

	/**
	 * 自动注入主表mapper
	 */
	@Autowired
	protected D mapper;

	/**
	 * 新增entity
	 */
	public void insert(T entity) {
		Integer rows = mapper.insert(entity);
		if (rows != 1)
			throw new BaseException("新增时出现未知异常！");
	}

	/**
	 * 动态新增entity
	 */
	public void insertSelective(T entity) {
		Integer rows = mapper.insertSelective(entity);
		if (rows != 1)
			throw new BaseException("动态新增时出现未知异常！");
	}

	/**
	 * 根据entityId删除记录
	 */
	public void deleteByPrimaryKey(Integer entityId) {
		Integer rows = mapper.deleteByPrimaryKey(entityId);
		if (rows != 1)
			throw new BaseException("删除时出现未知异常！");
	}

	/**
	 * 更新entity
	 */
	public void updateByPrimaryKey(T entity) {
		Integer rows = mapper.updateByPrimaryKey(entity);
		if (rows != 1)
			throw new BaseException("更新时出现未知异常！");
	}

	/**
	 * 动态更新entity
	 */
	public void updateByPrimaryKeySelective(T entity) {
		Integer rows = mapper.updateByPrimaryKeySelective(entity);
		if (rows != 1)
			throw new BaseException("动态更新时出现未知异常！");
	}

	/**
	 * 根据entityId查询
	 */
	public T selectByPrimaryKey(Integer entityId) {
		return mapper.selectByPrimaryKey(entityId);
	}

}
