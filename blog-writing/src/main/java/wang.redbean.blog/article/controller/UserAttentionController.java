package wang.redbean.blog.article.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.article.model.entity.UserAttention;
import wang.redbean.blog.article.serivce.IUserAttentionService;
import wang.redbean.blog.base.controller.BaseController;
import wang.redbean.blog.base.entity.response.ServerResponse;
import wang.redbean.blog.log.Log;
import wang.redbean.blog.utils.SecurityUtils;


@RestController
@RequestMapping("/user/attention")
@Api("用户关注控制器类")
public class UserAttentionController extends BaseController<IUserAttentionService, UserAttention> {

    @Log("新增用户关注")
    @ApiOperation("新增用户关注")
    @PostMapping("/save")
    public ServerResponse attentionByUserId( UserAttention userAttention){
        userAttention.setUsername(SecurityUtils.getUsername());
        return ServerResponse.isSuccess(baseService.save(userAttention));
    }

    @Log("取消关注")
    @ApiOperation("取消关注")
    @PostMapping("/delete")
    public ServerResponse deleteAttentionByUserId( Long id){
        return super.delete(id);
    }


    @ApiOperation("获取当前用户所有关注信息")
    @GetMapping("/get")
    public ServerResponse getUserAttention(){
        return ServerResponse.success(baseService.getUserAttention(SecurityUtils.getUsername()));
    }
}
