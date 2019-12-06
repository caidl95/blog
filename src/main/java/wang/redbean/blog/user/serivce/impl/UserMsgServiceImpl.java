package wang.redbean.blog.user.serivce.impl;

import org.springframework.stereotype.Service;
import wang.redbean.blog.common.base.service.AbstractService;
import wang.redbean.blog.user.entity.UserMsg;
import wang.redbean.blog.user.mapper.UserMsgMapper;
import wang.redbean.blog.user.serivce.IUserMsgSerivce;

@Service
public class UserMsgServiceImpl extends AbstractService<UserMsg, UserMsgMapper> implements IUserMsgSerivce {


}
