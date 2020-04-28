package wang.redbean.blog.article.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wang.redbean.blog.article.model.entity.ArticleInfo;
import wang.redbean.blog.article.model.entity.ArticleRecived;
import wang.redbean.blog.article.serivce.IArticleInfoService;
import wang.redbean.blog.base.controller.BaseController;
import wang.redbean.blog.base.entity.response.ServerResponse;
import wang.redbean.blog.log.Log;
import wang.redbean.blog.utils.SecurityUtils;
import java.util.List;


@RestController
@RequestMapping("/article/info")
@Api("章详情控制器类")
public class ArticleInfoController extends BaseController<IArticleInfoService,ArticleInfo> {

    @Log("新增文章详情")
    @ApiOperation("新增文章详情")
    @PostMapping("/save")
    public ServerResponse save(ArticleRecived articleRecived, @RequestParam(value = "file")MultipartFile file){
        articleRecived.setUsername(SecurityUtils.getUsername());
        return ServerResponse.isSuccess(baseService.insert(articleRecived,file));
    }

    @Log("删除文章详情")
    @ApiOperation("删除文章详情")
    @GetMapping("/delete")
    public ServerResponse delete(@RequestParam(value = "idList") List<Long> idList){
       return ServerResponse.isSuccess(baseService.deleteByIds(idList));
    }

    @Log("修改文章详情")
    @ApiOperation("修改文章详情")
    @PostMapping("/update")
    public  ServerResponse update(ArticleInfo articleInfo){
        return super.update(articleInfo);
    }


}
