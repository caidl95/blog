package wang.redbean.blog.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.core.base.controller.BaseController;
import wang.redbean.blog.core.base.model.constant.ConstRole;
import wang.redbean.blog.core.base.model.response.ServerResponse;
import wang.redbean.blog.core.interceptor.OnlyAdmin;
import wang.redbean.blog.user.model.Role;
import wang.redbean.blog.user.serivce.IRoleService;

/**
 * 用户权限控制器类
 */
@RestController
@RequestMapping("/user/role")
public class RoleController extends BaseController<IRoleService> {

    @OnlyAdmin({ConstRole.USER_ROLE_ADMIN })
    @PostMapping("/save")
    public ServerResponse save( Role role){
        boolean result = service.save(role);
        if (result)
            return ServerResponse.createBySuccess();
        return ServerResponse.createByErrorMessage("新增权限时出现未知异常！");
    }

    @OnlyAdmin({ConstRole.USER_ROLE_ADMIN })
    @PostMapping("/delete")
    public ServerResponse deleteByRightsId(int rightsId){
        boolean result = service.removeById(rightsId);
        if (result)
            return ServerResponse.createBySuccess("删除权限成功！");
        return ServerResponse.createByErrorMessage("删除权限时出现未知异常！");
    }

    @OnlyAdmin({ConstRole.USER_ROLE_ADMIN })
    @PostMapping("/update")
    public ServerResponse updateByRightsId(Role role){
        boolean result = service.updateById(role);
        if (result)
            return ServerResponse.createBySuccess("更新权限成功！");
        return ServerResponse.createByErrorMessage("更新权限时出现未知异常！");
    }

    @GetMapping("/get")
    public ServerResponse getById(Integer id){
        return ServerResponse.createBySuccess(service.getById(id));
    }

    @GetMapping("/")
    public ServerResponse getAll(){
        return ServerResponse.createBySuccess(service.list());
    }
}
