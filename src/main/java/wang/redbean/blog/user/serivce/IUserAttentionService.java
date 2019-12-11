package wang.redbean.blog.user.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import wang.redbean.blog.user.entity.UserAttention;
import wang.redbean.blog.user.entity.vo.UserAttentionVo;

import java.util.List;

/**
 * 用户关注业务接口类
 */
public interface IUserAttentionService extends IService<UserAttention> {

    List<UserAttentionVo> getUserAttention(Integer userId);
}
