package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import wang.redbean.blog.core.base.exception.BaseException;
import wang.redbean.blog.user.entity.Role;
import wang.redbean.blog.user.mapper.RoleMapper;
import wang.redbean.blog.user.serivce.IRoleService;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public boolean save(Role entity) {
        if (StringUtils.isBlank(entity.getName()))
            throw new BaseException("权限名称不能为空");
        return super.save(entity);
    }

    @Override
    public boolean updateById(Role entity) {
        if (StringUtils.isBlank(entity.getName()))
            throw new BaseException("权限名称不能为空");
        return super.updateById(entity);
    }
}
