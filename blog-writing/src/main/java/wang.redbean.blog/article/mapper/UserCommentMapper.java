package wang.redbean.blog.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wang.redbean.blog.article.model.entity.UserComment;

/**
 * 用户评论映射接口类
 */
@Mapper
public interface UserCommentMapper extends BaseMapper<UserComment> {

}
