package wang.redbean.blog.common.service;


import com.baomidou.mybatisplus.extension.service.IService;
import wang.redbean.blog.common.model.Category;

import java.util.List;

public interface ICategoryService extends IService<Category> {
    /**
     * 获取Category分类
     */
    List<Category> getChildrenParallelCategory(Integer categoryId);

    /**
     * 查询子当前节点的id和递归子节点的id
     */
    List<Integer> selectCategoryAndChildrenById(Integer categoryId);


}
