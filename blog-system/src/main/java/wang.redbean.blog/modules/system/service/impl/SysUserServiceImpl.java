package wang.redbean.blog.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import wang.redbean.blog.base.exception.BadRequestException;
import wang.redbean.blog.modules.system.entity.*;
import wang.redbean.blog.modules.system.mapper.SysUserMapper;
import wang.redbean.blog.modules.system.service.ISysUserRoleService;
import wang.redbean.blog.modules.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wang.redbean.blog.utils.ValidationUtil;

import java.util.List;

/**
 * @Description 系统用户业务实现
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements ISysUserService {


    @Autowired
    private ISysUserRoleService sysUserRoleService;

    @Transactional
    @Override
    public boolean reg(String username, String password) {
        ValidationUtil.isNullByString( username, password,"用户名或密码");
        SysUserEntity userEntity = selectUserByName(username);//查询名称是否被占用
        if (userEntity != null)
            throw new BadRequestException("用户名已存在,请重新输入！");
        SysUserEntity user = new SysUserEntity();
        user.setUsername(username);
        user.setPassword(new BCryptPasswordEncoder().encode(password));//对新增密码加密

        boolean result = super.save(user);//确认新增
        ValidationUtil.isFalse(result ,"新增用户时");
        result = sysUserRoleService.save(new SysUserRoleEntity(user.getId()));
        ValidationUtil.isFalse(result ,"默认新增用户权限");
        return true;
    }

    @Override
    public boolean resetPassword(String passwordOld, String passwordNew, Long id) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String md5PasswordOld = bCryptPasswordEncoder.encode(passwordOld);
        //防止横向越权，要校验一下这个用户的旧密码，一定要指定是这个用户，因为我们会查询一个count（1），如果不知道id，那么结果就是true coint>0
        int resultCount = baseMapper.checkPassword(md5PasswordOld, id);
        if (resultCount == 0)
            throw new BadRequestException("旧密码错误");
        return ValidationUtil.retBool( baseMapper.updateUserPassword( id, bCryptPasswordEncoder.encode(passwordNew)));
    }

    /**
     * 根据用户名查询实体
     * @Param  username 用户名
     * @Return SysUserEntity 用户实体
     */
    @Override
    public SysUserEntity selectUserByName(String username) {
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUserEntity::getUsername,username);
        return this.baseMapper.selectOne(queryWrapper);
    }

    /**
     * 通过用户ID查询角色集合
     * @Param  userId 用户ID
     * @Return List<SysRoleEntity> 角色名集合
     */
    @Override
    public List<SysRoleEntity> selectSysRoleByUserId(Long userId) {
        return this.baseMapper.selectSysRoleByUserId(userId);
    }

    /**
     * 根据用户ID查询权限集合
     * @Param userId 用户ID
     * @Return List<SysMenuEntity> 角色名集合
     */
    @Override
    public List<SysMenuEntity> selectSysMenuByUserId(Long userId) {
        return this.baseMapper.selectSysMenuByUserId(userId);
    }
}