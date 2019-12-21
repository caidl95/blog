package wang.redbean.blog.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wang.redbean.blog.common.entity.Category;
import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {

    Category selectByName(String categoryName);

    List<Category> selectCategoryChildrenByParentId(Integer parentId);
}
