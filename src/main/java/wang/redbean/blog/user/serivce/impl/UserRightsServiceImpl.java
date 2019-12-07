package wang.redbean.blog.user.serivce.impl;

import org.springframework.stereotype.Service;
import wang.redbean.blog.user.entity.UserRights;
import wang.redbean.blog.user.mapper.UserRightsMapper;
import wang.redbean.blog.user.serivce.IUserRightsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 用户权限业务实现类
 */
@Service
public class UserRightsServiceImpl extends ServiceImpl<UserRightsMapper,UserRights> implements IUserRightsService {



}
