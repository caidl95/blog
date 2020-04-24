package wang.redbean.blog.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import wang.redbean.blog.modules.system.entity.SysUserRoleEntity;
import wang.redbean.blog.modules.system.mapper.SysUserRoleMapper;
import wang.redbean.blog.modules.system.service.ISysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * @Description 用户与角色业务实现
 */
@Service("iSysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRoleEntity> implements ISysUserRoleService {

    @Override
    public boolean save(SysUserRoleEntity entity) {
        return super.save(entity);
    }
}