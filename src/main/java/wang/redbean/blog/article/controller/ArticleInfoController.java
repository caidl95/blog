package wang.redbean.blog.article.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wang.redbean.blog.article.entity.ArticleInfo;
import wang.redbean.blog.article.entity.ArticleRecived;
import wang.redbean.blog.article.serivce.IArticleInfoService;
import wang.redbean.blog.article.serivce.impl.ArticleInfoServiceImpl;
import wang.redbean.blog.common.base.controller.BaseController;
import wang.redbean.blog.common.base.entity.response.ServerResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 章详情控制器类
 */
@RestController
@RequestMapping("/article/info")
public class ArticleInfoController extends BaseController<IArticleInfoService> {

    @Autowired
    private ArticleInfoServiceImpl articleInfoService;

    /**
     * 新增一个用户
     * @param session
     * @param articleRecived
     * @return
     */
    @PostMapping("save")
    public ServerResponse save(HttpSession session, ArticleRecived articleRecived, @RequestParam(value = "file")MultipartFile file){
//        articleRecived.setUserId(getUidFromSession(session));
        articleRecived.setUserId(3);
        Integer result = articleInfoService.insert(articleRecived,file);
        if(result == 1){
            return ServerResponse.createBySuccessMessage("保存成功");
        }else{
            return  ServerResponse.createByErrorMessage("保存失败");
        }
    }

    /**
     * 删除一篇文章
     * @param idList
     * @return
     */
    @GetMapping("/delete")
    public ServerResponse delete(@RequestParam(value = "idList",required=true) List<Integer> idList){
        Integer result = articleInfoService.deleteByIds(idList);
        if(result>0){
            return  ServerResponse.createBySuccess("删除成功",result);
        }else{
            return  ServerResponse.createByErrorMessage("删除失败");
        }
    }

    @PostMapping("/update")
    public  ServerResponse update(ArticleInfo articleInfo){
        Integer result = articleInfoService.updateInfoById(articleInfo);
        if(result>0){
            return  ServerResponse.createBySuccessMessage("修改成功");
        }else{
            return  ServerResponse.createByErrorMessage("修改失败");
        }
    }

    @GetMapping("/get")
    public ServerResponse get(HttpServletRequest request ,ArticleInfo articleInfo){
        List<ArticleInfo> articleInfoList =articleInfoService.getByParam(request,articleInfo);
        if(articleInfoList.size()>0){
            return ServerResponse.createBySuccess("查询成功",articleInfoList);
        }else{
            return  ServerResponse.createByErrorMessage("未查询到文章信息");
        }
    }
}
