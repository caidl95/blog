package wang.redbean.blog.article.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wang.redbean.blog.article.model.entity.ArticleInfo;
import wang.redbean.blog.article.model.entity.ArticleRecived;
import wang.redbean.blog.article.serivce.IArticleInfoService;
import wang.redbean.blog.base.controller.BaseController;
import wang.redbean.blog.base.entity.response.ServerResponse;
import wang.redbean.blog.utils.SecurityUtils;
import java.util.List;


@RestController
@RequestMapping("/article/info")
@Api("章详情控制器类")
public class ArticleInfoController extends BaseController<IArticleInfoService,ArticleInfo> {

    @PostMapping("/save")
    public ServerResponse save(ArticleRecived articleRecived, @RequestParam(value = "file")MultipartFile file){
        articleRecived.setUsername(SecurityUtils.getUsername());
        return ServerResponse.isSuccess(baseService.insert(articleRecived,file));
    }

    @GetMapping("/delete")
    public ServerResponse delete(@RequestParam(value = "idList",required=true) List<Integer> idList){
       return ServerResponse.isSuccess(baseService.deleteByIds(idList));
    }

    @PostMapping("/update")
    public  ServerResponse update(ArticleInfo articleInfo){
        return super.update(articleInfo);
    }


}
