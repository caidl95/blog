package wang.redbean.blog.base.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import wang.redbean.blog.base.entity.response.ServerResponse;

import java.io.Serializable;

/**
 * 控制器主类
 * @param <S>
 */
public class BaseController <S extends IService<T> , T> {

    @Autowired
    protected S baseService;

    /**
     * 增
     * @param entity  对应的实体类
     * @return 成功或失败
     */
    public ServerResponse save(T entity){
        return ServerResponse.isSuccess(this.baseService.save(entity));
    }

    /**
     * 删
     * @param id 查询条件
     * @return 成功或失败
     */
    public ServerResponse delete(Serializable id){
        return ServerResponse.isSuccess(this.baseService.removeById(id));
    }

    /**
     * 改
     * @param entity 对应的实体类
     * @return  成功或失败
     */
    public ServerResponse update(T entity){
        return ServerResponse.isSuccess(this.baseService.updateById(entity));
    }

    /**
     * 根据id查询
     * @param id 查询条件
     * @return 相关数据
     */
    public ServerResponse getById(Serializable id){
        return ServerResponse.success(this.baseService.getById(id));
    }

    /**
     * 查
     * @return 所有数据
     */
    public ServerResponse list(){
        return ServerResponse.success(this.baseService.list());
    }
}
