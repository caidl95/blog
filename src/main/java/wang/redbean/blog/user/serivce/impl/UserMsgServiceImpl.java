package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.user.entity.UserMsg;
import wang.redbean.blog.user.mapper.UserMsgMapper;
import wang.redbean.blog.user.serivce.IUserMsgService;

@Service
public class UserMsgServiceImpl extends ServiceImpl<UserMsgMapper,UserMsg> implements IUserMsgService {



}
