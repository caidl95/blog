package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.user.entity.UserGroup;
import wang.redbean.blog.user.mapper.UserGroupMapper;
import wang.redbean.blog.user.serivce.IUserGroupService;

/**
 * 权限业务实现类
 */
@Service
public class UserGroupServiceImpl extends ServiceImpl<UserGroupMapper,UserGroup> implements IUserGroupService {


}
