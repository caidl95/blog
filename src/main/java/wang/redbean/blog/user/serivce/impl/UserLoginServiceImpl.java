package wang.redbean.blog.user.serivce.impl;

import org.springframework.stereotype.Service;
import wang.redbean.blog.common.base.service.AbstractService;
import wang.redbean.blog.user.entity.UserLogin;
import wang.redbean.blog.user.mapper.UserLoginMapper;
import wang.redbean.blog.user.serivce.IUserLoginService;

@Service
public class UserLoginServiceImpl extends AbstractService<UserLogin, UserLoginMapper> implements IUserLoginService {

}
