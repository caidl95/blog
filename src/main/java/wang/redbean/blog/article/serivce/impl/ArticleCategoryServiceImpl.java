package wang.redbean.blog.article.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.redbean.blog.article.entity.ArticleCategory;
import wang.redbean.blog.article.mapper.ArticleCategoryMapper;
import wang.redbean.blog.article.serivce.IArticleCategoryService;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 文章类目业务实现类
 */
@Service
public class ArticleCategoryServiceImpl extends ServiceImpl<ArticleCategoryMapper, ArticleCategory> implements IArticleCategoryService {


    /**
     * 新增一个类别
     * @param entity
     * @return
     */
    @Override
    public boolean save(ArticleCategory entity) {
        return super.save(entity);
    }

    /**
     * 根据id批量删除类目
     * @param idList
     * @return
     */
    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return super.removeByIds(idList);
    }

    /**
     * 根据id修改文章类目
     * @param entity
     * @return
     */
    @Override
    public boolean updateById(ArticleCategory entity) {
        return super.updateById(entity);
    }

    /**
     * 根据id查询类目
     * @param id
     * @return
     */
    @Override
    public ArticleCategory getById(Serializable id) {
        return super.getById(id);
    }

    /**
     * 查询所有类目
     * @return
     */
    @Override
    public List<ArticleCategory> findAll() {
        List<ArticleCategory> articleCategoryList = baseMapper.findAll();
        return articleCategoryList;
    }

    /**
     * 按照类目类型查询
     * @param type
     * @return
     */
    @Override
    public ArticleCategory getByType(Integer type) {
        ArticleCategory articleCategory = baseMapper.getByType(type);
        return articleCategory;
    }

    /**
     * 按照类目名称查询
     * @param categoryName
     * @return
     */
    @Override
    public ArticleCategory getByName(String categoryName) {
        ArticleCategory articleCategory = baseMapper.getByName(categoryName);
        return articleCategory;
    }

    /**
     * 根据创建时间查询
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<ArticleCategory> getByTime(Date startTime, Date endTime) {
        List<ArticleCategory> articleCategoryList = baseMapper.getByTime(startTime,endTime);
        return articleCategoryList;
    }

    /**
     * 根据id删除类目
     * @param idList
     * @return
     */
    @Override
    public Integer deleteByIds(List<Integer> idList) {
        Integer i = baseMapper.deleteByIds(idList);
        return i;
    }
}
