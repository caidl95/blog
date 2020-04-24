package wang.redbean.blog.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import wang.redbean.blog.article.model.entity.ArticleInfo;
import wang.redbean.blog.article.model.entity.ArticleRecived;

import java.util.Date;
import java.util.List;

/**
 * 文章详情映射接口类
 */
@Mapper
public interface ArticleInfoMapper extends BaseMapper<ArticleInfo> {

    Integer save(@Param("articleRecived") ArticleRecived articleRecived);

    List<ArticleInfo> findAll();

    List<ArticleInfo> getByParam(@Param("articleInfo") ArticleInfo articleInfo, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

}
