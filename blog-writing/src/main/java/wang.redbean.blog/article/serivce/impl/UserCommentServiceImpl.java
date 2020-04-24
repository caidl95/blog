package wang.redbean.blog.article.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.article.mapper.UserCommentMapper;
import wang.redbean.blog.article.model.entity.UserComment;
import wang.redbean.blog.article.serivce.IUserCommentService;

/**
 * 用户评论业务实现类
 */
@Service
public class UserCommentServiceImpl extends ServiceImpl<UserCommentMapper, UserComment> implements IUserCommentService {
}
