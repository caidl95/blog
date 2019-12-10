package wang.redbean.blog.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.common.base.controller.BaseController;
import wang.redbean.blog.common.base.entity.constant.Const;
import wang.redbean.blog.common.base.entity.response.ServerResponse;
import wang.redbean.blog.user.entity.UserGroup;
import wang.redbean.blog.user.entity.vo.UserGroupVo;
import wang.redbean.blog.user.serivce.IUserGroupService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 权限控制器类
 */
@RestController
@RequestMapping("/user/group")
public class UserGroupController extends BaseController<IUserGroupService> {

    @PostMapping("/save")
    public ServerResponse allocationRight(Integer userId ,Integer... rightsType){
        System.err.println(userId);
        System.err.println(rightsType[0]);
        System.err.println(rightsType[1]);
        return ServerResponse.createBySuccess();
    }

    @PostMapping("/delete")
    public ServerResponse deleteByUserIdAndRightsType(HttpSession session,Integer userId , Integer rightsType){
        boolean result = service.deleteByUserIdAndRightsType(userId,rightsType);
        if (result){
            List<UserGroupVo> userGroupVoList = service.selectByUserId(userId);
            if (!userGroupVoList.isEmpty())
                session.setAttribute(Const.SESSION_KEY_USER_GROUP, userGroupVoList);
            return ServerResponse.createBySuccess("删除用户权限组成功！");
        }
       return ServerResponse.createByErrorMessage("删除时用户权限组出现未知异常!");
    }

    @GetMapping("/get")
    public ServerResponse getByUserId(Integer userId){
        return ServerResponse.createBySuccess(service.selectByUserId(userId));
    }

}
