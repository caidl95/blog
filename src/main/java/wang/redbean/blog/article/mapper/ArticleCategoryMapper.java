package wang.redbean.blog.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import wang.redbean.blog.article.entity.ArticleCategory;

import java.util.Date;
import java.util.List;

/**
 * 文章类目映射接口类
 */
public interface ArticleCategoryMapper extends BaseMapper<ArticleCategory> {

    @Select("findOne")
    ArticleCategory findOne(Integer id);

    @Select("findAll")
    List<ArticleCategory> findAll();

    @Select("getByType")
    ArticleCategory getByType(@Param("categoryType") Integer categoryType);

    @Select("getByName")
    ArticleCategory getByName(@Param("categoryName") String categoryName);

    @Select("getByTime")
    List<ArticleCategory> getByTime(@Param("startTime") Date startTime,@Param("endTime") Date endTime);

    @Delete("deleteByIds")
    Integer deleteByIds(@Param("idList") List<Integer> idList);


}
