package wang.redbean.blog.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wang.redbean.blog.article.model.entity.UserPraise;

/**
 * 用户点赞映射接口类
 */
@Mapper
public interface UserPraiseMapper extends BaseMapper<UserPraise> {
}
