package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.common.base.exception.BaseException;
import wang.redbean.blog.user.entity.UserGroup;
import wang.redbean.blog.user.entity.vo.UserGroupVo;
import wang.redbean.blog.user.mapper.UserGroupMapper;
import wang.redbean.blog.user.serivce.IUserGroupService;

import java.util.List;

/**
 * 权限业务实现类
 */
@Service
public class UserGroupServiceImpl extends ServiceImpl<UserGroupMapper,UserGroup> implements IUserGroupService {

    @Override
    public List<UserGroupVo> selectByUserId(Integer userId) {
        if (userId==null||userId == 0)
            throw new BaseException("获取权限的用户ID丢失！");
        return baseMapper.selectByUserId(userId);
    }
}
