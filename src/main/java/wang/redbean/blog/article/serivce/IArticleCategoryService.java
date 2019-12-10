package wang.redbean.blog.article.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import wang.redbean.blog.article.entity.ArticleCategory;

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
     * 根据类目类别查询
     * @param categoryType
     * @return
     */
    ArticleCategory getByType(Integer categoryType);

    /**
     * 根据类目名称查询
     * @param categoryName
     * @return
     */
    ArticleCategory getByName(String categoryName);

    /**
     * 根据创建时间查询
     * @param startTime
     * @param endTime
     * @return
     */
    List<ArticleCategory> getByTime(Date startTime,Date endTime);

    /**
     * 根据id删除类目
     * @param idList
     * @return
     */
    Integer deleteByIds(List<Integer> idList);
}
