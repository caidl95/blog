package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.user.entity.UserAttention;
import wang.redbean.blog.user.mapper.UserAttentionMapper;
import wang.redbean.blog.user.serivce.IUserAttentionService;

/**
 * 用户关注业务实现类
 */
@Service
public class UserAttentionServiceImpl extends ServiceImpl<UserAttentionMapper, UserAttention> implements IUserAttentionService {

}
