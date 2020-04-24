package wang.redbean.blog.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wang.redbean.blog.article.model.entity.Category;
import java.util.List;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    Category selectByName(String categoryName);

    List<Category> selectCategoryChildrenByParentId(Long parentId);
}
