package wang.redbean.blog.user.serivce.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import wang.redbean.blog.core.base.exception.BaseException;
import wang.redbean.blog.user.entity.UserRights;
import wang.redbean.blog.user.mapper.UserRightsMapper;
import wang.redbean.blog.user.serivce.IUserRightsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Date;

/**
 * 用户权限业务实现类
 */
@Service
public class UserRightsServiceImpl extends ServiceImpl<UserRightsMapper,UserRights> implements IUserRightsService {

    @Override
    public boolean save(UserRights entity) {
        if (StringUtils.isBlank(entity.getRightsName()) || entity.getRightsType() ==null)
            throw new BaseException("权限名称或权限编码不能为空！");
        return super.save(entity);
    }

    @Override
    public boolean updateById(UserRights entity) {
        if (StringUtils.isBlank(entity.getRightsName()) || entity.getRightsType() ==null)
            throw new BaseException("权限名称或权限编码不能为空！");
        entity.setUpdateTime(new Date());
        return super.updateById(entity);
    }
}
