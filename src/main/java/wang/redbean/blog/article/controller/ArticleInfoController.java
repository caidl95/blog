package wang.redbean.blog.article.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wang.redbean.blog.article.entity.ArticleInfo;
import wang.redbean.blog.article.entity.ArticleRecived;
import wang.redbean.blog.article.serivce.IArticleInfoService;
import wang.redbean.blog.core.base.controller.BaseController;
import wang.redbean.blog.core.base.model.response.ServerResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 章详情控制器类
 */
@RestController
@RequestMapping("/article/info")
public class ArticleInfoController extends BaseController<IArticleInfoService> {

    /**
     * 新增一个用户
     * @param session
     * @param articleRecived
     * @return
     */
    @PostMapping("/save")
    public ServerResponse save(HttpSession session, ArticleRecived articleRecived, @RequestParam(value = "file")MultipartFile file){
        articleRecived.setUserId(getUidFromSession(session));
        boolean result = service.insert(articleRecived,file);
        if(result)
            return ServerResponse.createBySuccessMessage("保存成功");
        return  ServerResponse.createByErrorMessage("保存失败");

    }

    /**
     * 删除一篇文章
     * @param idList
     * @return
     */
    @GetMapping("/delete")
    public ServerResponse delete(@RequestParam(value = "idList",required=true) List<Integer> idList){
        Integer result = service.deleteByIds(idList);
        if(result>0){
            return  ServerResponse.createBySuccess("删除成功",result);
        }else{
            return  ServerResponse.createByErrorMessage("删除失败");
        }
    }

    @PostMapping("/update")
    public  ServerResponse update(ArticleInfo articleInfo){
        Integer result = service.updateInfoById(articleInfo);
        if(result>0){
            return  ServerResponse.createBySuccessMessage("修改成功");
        }else{
            return  ServerResponse.createByErrorMessage("修改失败");
        }
    }

    @GetMapping("/get")
    public ServerResponse get(HttpServletRequest request ,ArticleInfo articleInfo){
        List<ArticleInfo> articleInfoList = service.getByParam(request,articleInfo);
        if(articleInfoList.size()>0){
            return ServerResponse.createBySuccess("查询成功",articleInfoList);
        }else{
            return  ServerResponse.createByErrorMessage("未查询到文章信息");
        }
    }
}
