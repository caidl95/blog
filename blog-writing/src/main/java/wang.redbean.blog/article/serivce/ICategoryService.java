package wang.redbean.blog.article.serivce;


import com.baomidou.mybatisplus.extension.service.IService;
import wang.redbean.blog.article.model.entity.Category;

import java.util.List;

public interface ICategoryService extends IService<Category> {
    /**
     * 获取Category分类
     */
    List<Category> getChildrenParallelCategory(Long categoryId);

    /**
     * 查询子当前节点的id和递归子节点的id
     */
    List<Long> selectCategoryAndChildrenById(Long categoryId);


}
