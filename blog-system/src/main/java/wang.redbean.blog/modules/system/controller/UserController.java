package wang.redbean.blog.modules.system.controller;

import wang.redbean.blog.base.controller.BaseController;
import wang.redbean.blog.base.entity.response.ServerResponse;
import wang.redbean.blog.modules.security.util.SecurityUtil;
import wang.redbean.blog.modules.system.entity.SysUserEntity;
import wang.redbean.blog.modules.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

/**
 * 普通用户
 */
@RestController
@RequestMapping("api/user")
@Api(tags = "用户")
public class UserController extends BaseController< ISysUserService , SysUserEntity> {


    @ApiOperation("注册新用户")
    @PostMapping("/reg")
    public ServerResponse reg( String username, String password){
        return ServerResponse.isSuccess(baseService.reg(username,password));
    }


    @ApiOperation("在线更改密码")
    @PostMapping("/reset_password")
    public ServerResponse<String> resetPassword(String passwordOld, String passwordNew, HttpServletResponse response){
        boolean result = baseService.resetPassword(passwordOld,passwordNew, SecurityUtil.getUserId());
        if (result) {
            //清除token
            SecurityContextHolder.clearContext();
            return ServerResponse.success();
        }
        return ServerResponse.error();
    }

    @ApiOperation("查询当前在线用户数据")
    @GetMapping("/info")
    public ServerResponse userLogin(){
        return ServerResponse.success("用户端信息", SecurityUtil.getUserInfo());
    }


    @ApiOperation("查询用户数据")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/list")
    public ServerResponse list(){
        return super.list();
    }


}
