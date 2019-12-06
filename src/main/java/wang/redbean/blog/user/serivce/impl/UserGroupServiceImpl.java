package wang.redbean.blog.user.serivce.impl;

import org.springframework.stereotype.Service;
import wang.redbean.blog.common.base.service.AbstractService;
import wang.redbean.blog.user.entity.UserGroup;
import wang.redbean.blog.user.mapper.UserGroupMapper;
import wang.redbean.blog.user.serivce.IUserGroupService;

@Service
public class UserGroupServiceImpl extends AbstractService<UserGroup, UserGroupMapper> implements IUserGroupService {

}
