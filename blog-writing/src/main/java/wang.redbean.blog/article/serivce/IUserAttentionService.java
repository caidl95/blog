package wang.redbean.blog.article.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import wang.redbean.blog.article.model.entity.UserAttention;
import wang.redbean.blog.article.model.vo.UserAttentionVo;

import java.util.List;

/**
 * 用户关注业务接口类
 */
public interface IUserAttentionService extends IService<UserAttention> {

    List<UserAttentionVo> getUserAttention(String username);
}
