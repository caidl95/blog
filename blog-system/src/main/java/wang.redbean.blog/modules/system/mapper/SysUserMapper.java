package wang.redbean.blog.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wang.redbean.blog.modules.system.entity.SysMenuEntity;
import wang.redbean.blog.modules.system.entity.SysRoleEntity;
import wang.redbean.blog.modules.system.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 系统用户DAO
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

    /**
     * 通过用户ID查询角色集合
     */
    List<SysRoleEntity> selectSysRoleByUserId(Long userId);
    /**
     * 通过用户ID查询权限集合
     */
    List<SysMenuEntity> selectSysMenuByUserId(Long userId);

    /**
     * 根据用户id与密码查询密码是否有效
     * @param password 密码
     * @param id id
     * @return 对应的数量
     */
    Integer checkPassword(@Param("password") String password, @Param("id") Long id);

    /**
     *  根据id修改密码
     * @param id 用户id
     * @param password 密码
     * @return 执行数量
     */
    Integer updateUserPassword(@Param("id") Long id, @Param("password") String password);
}
