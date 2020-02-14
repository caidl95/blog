package wang.redbean.blog.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wang.redbean.blog.user.model.UserAttention;
import wang.redbean.blog.user.model.vo.UserAttentionVo;

import java.util.List;

/**
 * 用户关注映射接口类
 */
public interface UserAttentionMapper extends BaseMapper<UserAttention> {

    List<UserAttentionVo> getUserAttention(Integer userId);
}
