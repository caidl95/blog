package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.core.base.exception.BaseException;
import wang.redbean.blog.user.entity.UserGroup;
import wang.redbean.blog.user.entity.vo.UserGroupVo;
import wang.redbean.blog.user.mapper.UserGroupMapper;
import wang.redbean.blog.user.serivce.IUserGroupService;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限业务实现类
 */
@Service
public class UserGroupServiceImpl extends ServiceImpl<UserGroupMapper,UserGroup> implements IUserGroupService {

    @Override
    public boolean allocationRights(Integer userId, Integer... rightsType) {
        if (userId==null || rightsType==null || rightsType.length==0)
            throw new BaseException("未选择权限");
        List<UserGroup> userGroupList = new ArrayList<>();
        for (Integer rightsId: rightsType){
            UserGroup userGroup = new UserGroup();
            userGroup.setUserId(userId);
            userGroup.setRightsType(rightsId);
            userGroupList.add(userGroup);
        }
        return retBool( baseMapper.insert(userGroupList));
    }

    @Override
    public List<UserGroupVo> selectByUserId(Integer userId) {
        if (userId==null||userId == 0)
            throw new BaseException("获取权限的用户ID丢失！");
        return baseMapper.selectByUserId(userId);
    }

    @Override
    public boolean deleteByUserIdAndRightsType(Integer userId, Integer rightsType) {
        if (userId == null || rightsType == null)
            throw new BaseException("需要删除的用户组信息不明确");
        return retBool(baseMapper.deleteByUserIdAndRightsType(userId,rightsType));
    }
}
