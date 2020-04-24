package wang.redbean.blog.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.StringUtils;
import wang.redbean.blog.modules.security.entity.SelfUserEntity;
import wang.redbean.blog.modules.security.util.SecurityUtil;
import wang.redbean.blog.modules.system.entity.SysMenuEntity;
import wang.redbean.blog.modules.system.service.ISysUserService;

import java.util.*;

/**
 * 自定义权限拦截
 * 通过
 * @ PreAuthorize( " @el.check(''/user/menuList','sys:user:info'') ")
 */
//@Service(value = "el")
public class ElPermissionConfig {

    @Autowired
    private ISysUserService sysUserService;

    public Boolean check(String ...permissions){
        SelfUserEntity selfUserEntity = SecurityUtil.getUserInfo();
        Collection<GrantedAuthority> authorities = selfUserEntity.getAuthorities();
        if (!StringUtils.isEmpty(authorities)){
            for (GrantedAuthority grantedAuthority  : authorities){
                // 当前用户若是超级管理员则无需再进行验证
                if ("SUPER_ADMIN".equals(grantedAuthority.getAuthority())) {
                    return true;
                } else {
                    // 查询用户权限(这里可以将权限放入缓存中提升效率)
                    List<SysMenuEntity> sysMenuEntityList = sysUserService.selectSysMenuByUserId(selfUserEntity.getId());
                    if (!StringUtils.isEmpty(sysMenuEntityList) && !StringUtils.isEmpty(permissions)){
                        //将字符串数组转为List集合
                        List<String> list = new ArrayList<>(Arrays.asList(permissions));
                        //组长从数据库中拿出的List集合
                        List<String> permissionList = new ArrayList<>();
                        for (SysMenuEntity sysMenuEntity:sysMenuEntityList) {
                            permissionList.add(sysMenuEntity.getPermission());
                        }
                        //将 两个list 进行排序
                        permissionList.sort(Comparator.comparing(String::hashCode));
                        list.sort(Comparator.comparing(String::hashCode));
                        // 将两个list转成字符串进行权限对比 权限完全一样才可以放行
                        return list.toString().equals(permissionList.toString());
                    }
                }
            }
        }
        return false;
    }
}
