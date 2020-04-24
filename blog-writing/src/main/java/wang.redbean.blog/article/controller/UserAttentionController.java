package wang.redbean.blog.article.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.redbean.blog.article.model.entity.UserAttention;
import wang.redbean.blog.article.serivce.IUserAttentionService;
import wang.redbean.blog.base.controller.BaseController;
import wang.redbean.blog.base.entity.response.ServerResponse;
import wang.redbean.blog.utils.SecurityUtils;


@RestController
@RequestMapping("/user/attention")
@Api("用户关注控制器类")
public class UserAttentionController extends BaseController<IUserAttentionService, UserAttention> {
    
    @PostMapping("/save")
    public ServerResponse attentionByUserId( UserAttention userAttention){
        userAttention.setUsername(SecurityUtils.getUsername());
        return ServerResponse.isSuccess(baseService.save(userAttention));
    }

    @PostMapping("/delete")
    public ServerResponse deleteAttentionByUserId( Integer attentionId){
        return ServerResponse.isSuccess(baseService.removeById(attentionId));
    }

    @GetMapping("/get")
    public ServerResponse getUserAttention(){
        return ServerResponse.success(baseService.getUserAttention(SecurityUtils.getUsername()));
    }
}
