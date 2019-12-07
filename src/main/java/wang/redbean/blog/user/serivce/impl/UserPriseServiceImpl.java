package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.user.entity.UserPraise;
import wang.redbean.blog.user.mapper.UserPraiseMapper;
import wang.redbean.blog.user.serivce.IUserPriseService;

/**
 * 用户点赞业务实现类
 */
@Service
public class UserPriseServiceImpl extends ServiceImpl<UserPraiseMapper, UserPraise> implements IUserPriseService {

}
