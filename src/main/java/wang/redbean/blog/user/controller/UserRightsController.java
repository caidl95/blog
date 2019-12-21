package wang.redbean.blog.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.core.base.controller.BaseController;
import wang.redbean.blog.core.base.entity.response.ServerResponse;
import wang.redbean.blog.user.entity.UserRights;
import wang.redbean.blog.user.serivce.IUserRightsService;

import javax.servlet.http.HttpSession;

/**
 * 用户权限控制器类
 */
@RestController
@RequestMapping("/user/rights")
public class UserRightsController extends BaseController<IUserRightsService> {

    @PostMapping("/save")
    public ServerResponse save(HttpSession session, UserRights userRights){
        //TODO 检查权限
        boolean result = service.save(userRights);
        if (result)
            return ServerResponse.createBySuccess();
        return ServerResponse.createByErrorMessage("新增权限时出现未知异常！");
    }

    @PostMapping("/delete")
    public ServerResponse deleteByRightsId(int rightsId){
        //TODO 检查权限
        boolean result = service.removeById(rightsId);
        if (result)
            return ServerResponse.createBySuccess("删除权限成功！");
        return ServerResponse.createByErrorMessage("删除权限时出现未知异常！");
    }

    @PostMapping("/update")
    public ServerResponse updateByRightsId(UserRights userRights){
        //TODO 检查权限
        boolean result = service.updateById(userRights);
        if (result)
            return ServerResponse.createBySuccess("更新权限成功！");
        return ServerResponse.createByErrorMessage("更新权限时出现未知异常！");
    }

    @GetMapping("/get")
    public ServerResponse getByRightsId(Integer rightsId){
        //TODO 检查权限
        return ServerResponse.createBySuccess(service.getById(rightsId));
    }

    @GetMapping("/")
    public ServerResponse getAll(){
        //TODO 检查权限
        return ServerResponse.createBySuccess(service.list());
    }
}
