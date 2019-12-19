package wang.redbean.blog.article.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.article.entity.ArticleCategory;
import wang.redbean.blog.article.entity.dto.ArticleCategoryDto;
import wang.redbean.blog.article.entity.param.ArticleCategoryParam;
import wang.redbean.blog.article.mapper.ArticleCategoryMapper;
import wang.redbean.blog.article.serivce.IArticleCategoryService;
import wang.redbean.blog.common.util.ParamToDtoUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

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
     * 根据参数查询
     * @return
     */
    @Override
    public List<ArticleCategory> getByParam(ArticleCategoryParam articleCategoryParam) {
        ParamToDtoUtil<ArticleCategoryParam, ArticleCategoryDto> paramToDtoUtil = new ParamToDtoUtil<>();
        ArticleCategoryDto articleCategoryDto = paramToDtoUtil.getParamToDto( articleCategoryParam, new ArticleCategoryDto());
        articleCategoryDto.setCategoryId(articleCategoryParam.getCategoryId());
        articleCategoryDto.setCategoryName(articleCategoryParam.getCategoryName());
        articleCategoryDto.setCategoryType(articleCategoryParam.getCategoryType());
        return baseMapper.getByParam(articleCategoryDto);
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
