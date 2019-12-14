package wang.redbean.blog.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import wang.redbean.blog.article.entity.ArticleContent;
import wang.redbean.blog.article.entity.ArticleInfo;
import wang.redbean.blog.article.entity.ArticleRecived;

import java.util.Date;
import java.util.List;

/**
 * 文章详情映射接口类
 */
public interface ArticleInfoMapper extends BaseMapper<ArticleInfo> {

    @Insert("save")
    Integer save(@Param("articleRecived")ArticleRecived articleRecived);

    @Delete("deleteByIds")
    Integer deleteByIds(@Param("idList")List<Integer> idList);

    @Update("updateInfoById")
    Integer updateInfoById(@Param("articleInfo") ArticleInfo articleInfo);

    @Select("findAll")
    List<ArticleInfo> findAll();

    @Select("getByParam")
    List<ArticleInfo> getByParam(@Param("articleInfo") ArticleInfo articleInfo, @Param("startTime") Date startTime, @Param("endTime") Date endTime);


}
