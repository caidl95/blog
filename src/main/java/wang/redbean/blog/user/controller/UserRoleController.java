package wang.redbean.blog.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.core.base.controller.BaseController;
import wang.redbean.blog.core.base.entity.response.ServerResponse;
import wang.redbean.blog.user.serivce.IUserRoleService;

/**
 * 权限控制器类
 */
@RestController
@RequestMapping("/user/group")
public class UserRoleController extends BaseController<IUserRoleService> {

    @PostMapping("/save")
    public ServerResponse allocationRights(Integer userId ,Integer... roleIds){
        boolean result = service.saveBatch(userId,roleIds);
        if (result)
            return ServerResponse.createBySuccess("分配权限成功！");
        return ServerResponse.createByErrorMessage("分配权限出现未知异常！");
    }



}
