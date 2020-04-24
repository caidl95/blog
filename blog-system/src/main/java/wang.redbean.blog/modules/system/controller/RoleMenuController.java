package wang.redbean.blog.modules.system.controller;


import wang.redbean.blog.base.controller.BaseController;
import wang.redbean.blog.base.entity.response.ServerResponse;
import wang.redbean.blog.log.Log;
import wang.redbean.blog.modules.system.entity.SysRoleMenuEntity;
import wang.redbean.blog.modules.system.service.ISysRoleMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("api/role/menu")
@Api(tags = "角色权限")
public class RoleMenuController extends BaseController<ISysRoleMenuService , SysRoleMenuEntity> {

    @Log("新增角色权限数据")
    @ApiOperation("新增角色权限数据")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ServerResponse save(SysRoleMenuEntity sysRoleMenuEntity){
        return super.save(sysRoleMenuEntity);
    }

    @Log("修改角色权限数据")
    @ApiOperation("修改角色权限数据")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update")
    public ServerResponse update(SysRoleMenuEntity sysRoleMenuEntity){
        return super.update(sysRoleMenuEntity);
    }

    @Log("删除角色权限数据")
    @ApiOperation("删除角色权限数据")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}/delete")
    public ServerResponse delete(@PathVariable(value="id") Serializable id){
        return super.delete(id);
    }

    @ApiOperation("查询全部角色权限数据")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list")
    public ServerResponse list(){
        return super.list();
    }

    @ApiOperation("根据id查询角色权限数据")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}/get")
    public ServerResponse getById(@PathVariable(value="id") Serializable id){
        return super.getById(id);
    }
}
