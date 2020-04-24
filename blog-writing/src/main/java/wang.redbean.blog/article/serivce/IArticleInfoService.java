package wang.redbean.blog.article.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;
import wang.redbean.blog.article.model.entity.ArticleInfo;
import wang.redbean.blog.article.model.entity.ArticleRecived;
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
    boolean insert(ArticleRecived articleRecived, MultipartFile file);

    /**
     * 根据id删除文章
     * @param idList
     * @return
     */
    boolean deleteByIds(List<Integer> idList);




}
