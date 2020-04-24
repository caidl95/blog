package wang.redbean.blog.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import wang.redbean.blog.modules.system.entity.SysRoleMenuEntity;
import wang.redbean.blog.modules.system.mapper.SysRoleMenuMapper;
import wang.redbean.blog.modules.system.service.ISysRoleMenuService;
import org.springframework.stereotype.Service;
import wang.redbean.blog.utils.ValidationUtil;

/**
 * @Description 角色与权限业务实现
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenuEntity> implements ISysRoleMenuService {

    @Override
    public boolean updateById(SysRoleMenuEntity entity) {
        ValidationUtil.isNullBySerializable(entity.getId(),"id");
        return super.updateById(entity);
    }

    @Override
    public boolean save(SysRoleMenuEntity entity) {
        ValidationUtil.isNullBySerializable( entity.getMenuId(), entity.getRoleId(),"分配权限角色时权限或角色id");
        return super.save(entity);
    }
}