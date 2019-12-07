package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.user.entity.UserLogin;
import wang.redbean.blog.user.mapper.UserLoginMapper;
import wang.redbean.blog.user.serivce.IUserLoginService;

/**
 * 登录日志业务实现类
 */
@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper ,UserLogin> implements IUserLoginService {



}
