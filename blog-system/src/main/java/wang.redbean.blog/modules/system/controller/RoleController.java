package wang.redbean.blog.modules.system.controller;


import wang.redbean.blog.base.controller.BaseController;
import wang.redbean.blog.base.entity.response.ServerResponse;
import wang.redbean.blog.log.Log;
import wang.redbean.blog.modules.system.entity.SysRoleEntity;
import wang.redbean.blog.modules.system.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("api/role")
@Api(tags = "角色")
public class RoleController extends BaseController< ISysRoleService, SysRoleEntity> {

    @Log("新增角色数据")
    @ApiOperation("新增角色数据")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ServerResponse save(SysRoleEntity sysRoleEntity){
        return super.save(sysRoleEntity);
    }

    @Log("修改角色数据")
    @ApiOperation("修改角色数据")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update")
    public ServerResponse update(SysRoleEntity sysRoleEntity){
        return super.update(sysRoleEntity);
    }

    @Log("删除角色数据")
    @ApiOperation("删除角色数据")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}/delete")
    public ServerResponse delete(@PathVariable(value="id") Serializable id){
        return super.delete(id);
    }

    @ApiOperation("查询所有角色数据")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list")
    public ServerResponse list(){
       return super.list();
    }

    @ApiOperation("根据id查询角色数据")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}/get")
    public ServerResponse getById(@PathVariable(value="id") Serializable id){
        return super.getById(id);
    }
}
