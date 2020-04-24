package wang.redbean.blog.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import wang.redbean.blog.modules.system.entity.SysMenuEntity;
import wang.redbean.blog.modules.system.entity.SysRoleEntity;
import wang.redbean.blog.modules.system.entity.SysUserEntity;

import java.util.List;

/**
 * @Description 系统用户业务接口
 */
public interface ISysUserService extends IService<SysUserEntity> {

    /**
     * 根据用户名查询实体
     * @Param  username 用户名
     * @Return SysUserEntity 用户实体
     */
    SysUserEntity selectUserByName(String username);
    /**
     * 根据用户ID查询角色集合
     * @Param  userId 用户ID
     * @Return List<SysRoleEntity> 角色名集合
     */
    List<SysRoleEntity> selectSysRoleByUserId(Long userId);
    /**
     * 根据用户ID查询权限集合
     * @Param  userId 用户ID
     * @Return List<SysMenuEntity> 角色名集合
     */
    List<SysMenuEntity> selectSysMenuByUserId(Long userId);

    /**
     * 注册新的用户
     * @param username 用户名
     * @param password 密码
     * @return  成功或失败
     */
    boolean reg(String username, String password);

    /**
     * 重置密码
     * @param passwordOld 旧密码
     * @param passwordNew 新密码
     * @param id 用户名
     * @return 成功或失败
     */
    boolean resetPassword(String passwordOld, String passwordNew, Long id);
}