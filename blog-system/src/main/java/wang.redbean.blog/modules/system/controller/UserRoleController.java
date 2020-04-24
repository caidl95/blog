package wang.redbean.blog.modules.system.controller;

import wang.redbean.blog.base.controller.BaseController;
import wang.redbean.blog.base.entity.response.ServerResponse;
import wang.redbean.blog.log.Log;
import wang.redbean.blog.modules.system.entity.SysUserRoleEntity;
import wang.redbean.blog.modules.system.service.ISysUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.io.Serializable;

@RestController
@RequestMapping("api/user/role")
@Api(tags = "用户权限")
public class UserRoleController extends BaseController<ISysUserRoleService , SysUserRoleEntity> {

    @Log("新增用户权限数据")
    @ApiOperation("新增用户权限数据")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ServerResponse save(SysUserRoleEntity sysUserRoleEntity){
        return super.save(sysUserRoleEntity);
    }

    @Log("更新用户权限数据")
    @ApiOperation("更新用户权限数据")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update")
    public ServerResponse update(SysUserRoleEntity sysUserRoleEntity){
        return super.update(sysUserRoleEntity);
    }

    @Log("删除用户权限数据")
    @ApiOperation("删除用户权限数据")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}/delete")
    public ServerResponse delete(@PathVariable(value="id") Serializable id){
        return super.delete(id);
    }

    @ApiOperation("根据id查询用户权限数据")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}/get")
    public ServerResponse getById(@PathVariable(value="id") Serializable id){
        return super.getById(id);
    }

    @ApiOperation("查询用户权限数据")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/list")
    public ServerResponse list(){
        return super.list();
    }



}
