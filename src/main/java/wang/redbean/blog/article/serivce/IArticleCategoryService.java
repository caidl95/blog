package wang.redbean.blog.article.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import wang.redbean.blog.article.entity.ArticleCategory;
import wang.redbean.blog.article.entity.param.ArticleCategoryParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 文章类目业务实接口类
 */
public interface IArticleCategoryService extends IService<ArticleCategory> {

    /**
     * 查询所有类目
     * @return
     */
    List<ArticleCategory> findAll();


    /**
     * 根据参数查询
     * @return
     */
    List<ArticleCategory> getByParam(ArticleCategoryParam articleCategoryParam);


    /**
     * 根据id删除类目
     * @param idList
     * @return
     */
    Integer deleteByIds(List<Integer> idList);
}
