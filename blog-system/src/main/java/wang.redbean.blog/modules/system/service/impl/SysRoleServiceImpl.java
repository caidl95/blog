package wang.redbean.blog.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import wang.redbean.blog.modules.system.entity.SysRoleEntity;
import wang.redbean.blog.modules.system.mapper.SysRoleMapper;
import wang.redbean.blog.modules.system.service.ISysRoleService;
import org.springframework.stereotype.Service;
import wang.redbean.blog.utils.ValidationUtil;

import java.io.Serializable;

/**
 * @Description 角色业务实现
 */
@Service("iSysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleEntity> implements ISysRoleService {

    @Override
    public boolean removeById(Serializable id) {
        ValidationUtil.isNullBySerializable(id ,"id");
        return super.removeById(id);
    }

    @Override
    public boolean updateById(SysRoleEntity entity) {
        ValidationUtil.isNullBySerializable(entity.getId(),"需要修改的对象的id");
        return super.updateById(entity);
    }
}