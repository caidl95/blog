package wang.redbean.blog.article.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.article.mapper.UserPraiseMapper;
import wang.redbean.blog.article.model.entity.UserPraise;
import wang.redbean.blog.article.serivce.IUserPriseService;

/**
 * 用户点赞业务实现类
 */
@Service
public class UserPriseServiceImpl extends ServiceImpl<UserPraiseMapper, UserPraise> implements IUserPriseService {

}
