package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.user.model.UserComment;
import wang.redbean.blog.user.mapper.UserCommentMapper;
import wang.redbean.blog.user.serivce.IUserCommentService;

/**
 * 用户评论业务实现类
 */
@Service
public class UserCommentServiceImpl extends ServiceImpl<UserCommentMapper,UserComment> implements IUserCommentService {
}
