package wang.redbean.blog.article.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wang.redbean.blog.article.model.entity.UserAttention;
import wang.redbean.blog.article.model.vo.UserAttentionVo;

import java.util.List;

/**
 * 用户关注映射接口类
 */
@Mapper
public interface UserAttentionMapper extends BaseMapper<UserAttention> {


}
