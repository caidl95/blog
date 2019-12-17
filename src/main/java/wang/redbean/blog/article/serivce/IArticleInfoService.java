package wang.redbean.blog.article.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;
import wang.redbean.blog.article.entity.ArticleContent;
import wang.redbean.blog.article.entity.ArticleInfo;
import wang.redbean.blog.article.entity.ArticleRecived;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 *文章详情业务接口类
 */
public interface IArticleInfoService extends IService<ArticleInfo> {

    /**
     * 新增
     * @param articleRecived
     * @return
     */
    Integer insert(ArticleRecived articleRecived, MultipartFile file);

    /**
     * 根据id删除文章
     * @param idList
     * @return
     */
    Integer deleteByIds(List<Integer> idList);

    /**
     * 根据id修改文章
     * @param articleInfo
     * @return
     */
    Integer updateInfoById(ArticleInfo articleInfo);

    /**
     * 查询全部文章
     * @return
     */
    List<ArticleInfo> findAll();

    /**
     * 根据参数查询
     * @param articleInfo
     * @param request
     * @return
     */
    List<ArticleInfo> getByParam(HttpServletRequest request, ArticleInfo articleInfo);


}
