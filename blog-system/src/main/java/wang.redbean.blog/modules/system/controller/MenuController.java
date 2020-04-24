package wang.redbean.blog.modules.system.controller;

import wang.redbean.blog.base.controller.BaseController;
import wang.redbean.blog.base.entity.response.ServerResponse;
import wang.redbean.blog.log.Log;
import wang.redbean.blog.modules.system.entity.SysMenuEntity;
import wang.redbean.blog.modules.system.service.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.io.Serializable;


@RestController
@RequestMapping("api/menu")
@Api(tags = "权限")
public class MenuController extends BaseController<ISysMenuService, SysMenuEntity> {

    @Log("新增权限数据")
    @ApiOperation("新增权限数据")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ServerResponse save(SysMenuEntity sysMenuEntity){
        return super.save(sysMenuEntity);
    }

    @Log("删除权限数据")
    @ApiOperation("删除权限数据")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}/delete")
    public ServerResponse delete(@PathVariable(value="id") Serializable id){
        return super.delete(id);
    }

    @Log("修改权限数据")
    @ApiOperation("修改权限数据")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update")
    public ServerResponse update(SysMenuEntity sysMenuEntity){
        return super.update(sysMenuEntity);
    }

    @ApiOperation("根据id查询权限数据")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}/get")
    public ServerResponse getById(@PathVariable(value="id") Serializable id){
        return super.getById(id);
    }

    @ApiOperation("查询所有权限数据")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list")
    public ServerResponse list(){
        return super.list();
    }

}
