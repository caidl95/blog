package wang.redbean.blog.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import wang.redbean.blog.article.entity.ArticleCategory;
import wang.redbean.blog.article.entity.dto.ArticleCategoryDto;

import java.util.List;

/**
 * 文章类目映射接口类
 */
public interface ArticleCategoryMapper extends BaseMapper<ArticleCategory> {

    ArticleCategory findOne(Integer id);

    List<ArticleCategory> findAll();

    /*@Select("getByType")
    ArticleCategory getByType(@Param("categoryType") Integer categoryType);

    @Select("getByName")
    ArticleCategory getByName(@Param("categoryName") String categoryName);*/

    List<ArticleCategory> getByParam(@Param("dto") ArticleCategoryDto dto);

    Integer deleteByIds(@Param("idList") List<Integer> idList);


}
