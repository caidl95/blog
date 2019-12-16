package wang.redbean.blog.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import wang.redbean.blog.user.entity.UserAttention;
import wang.redbean.blog.user.entity.vo.UserAttentionVo;

import java.util.List;

/**
 * 用户关注映射接口类
 */
public interface UserAttentionMapper extends BaseMapper<UserAttention> {

    List<UserAttentionVo> getUserAttention(Integer userId);
}
