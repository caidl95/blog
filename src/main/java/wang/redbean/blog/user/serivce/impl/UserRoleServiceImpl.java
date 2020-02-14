package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.core.base.exception.BaseException;
import wang.redbean.blog.user.model.UserRole;
import wang.redbean.blog.user.mapper.UserRoleMapper;
import wang.redbean.blog.user.serivce.IUserRoleService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    public boolean saveBatch(Integer userId ,Integer... roleIds){
        if (userId ==null || roleIds.length == 0)
            throw new BaseException("信息未填写完整或丢失！");
        baseMapper.deleteByUserId(userId);
        if (roleIds.length==1){
            return this.save(new UserRole(userId,roleIds[0]));
        }
        List<UserRole> userRoles = new ArrayList<>();
        for (Integer roleId : roleIds){
            userRoles.add(new UserRole(userId,roleId));
        }
        return this.saveBatch(userRoles);
    }


}
