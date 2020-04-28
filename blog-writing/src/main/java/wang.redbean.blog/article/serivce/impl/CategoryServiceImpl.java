package wang.redbean.blog.article.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import wang.redbean.blog.article.mapper.CategoryMapper;
import wang.redbean.blog.article.model.entity.Category;
import wang.redbean.blog.article.serivce.ICategoryService;
import wang.redbean.blog.base.exception.BadRequestException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {


    @Override
    public boolean save(Category entity) {
        if (entity.getParentId() == null || StringUtils.isBlank(entity.getName()))
            throw new BadRequestException("添加品类参数错误");
        Category result = baseMapper.selectOne(new QueryWrapper<Category>().lambda().eq(Category::getName,entity.getName()));
        if (result != null)
            throw new BadRequestException("已有此份类，无法添加");
        if (CollectionUtils.isEmpty(selectCategoryAndChildrenById(entity.getParentId())))
            throw new BadRequestException("上级分类不存在");
        return super.save(entity);
    }

    @Override
    public List<Category> getChildrenParallelCategory(Long categoryId) {
        List<Category> categoryList = baseMapper.selectCategoryChildrenByParentId(categoryId);
        if (CollectionUtils.isEmpty(categoryList))
            System.err.println("未找到当前分类的子分类");
        return categoryList;
    }

    @Override
    public List<Long>  selectCategoryAndChildrenById(Long categoryId) {
        Set<Category> categorySet =new HashSet<>();//初始化set
        findChildCategory(categorySet, categoryId);
        List<Long> categoryIdList = new ArrayList<>();
        if (categoryId != null) {
            for (Category category : categorySet) {
                categoryIdList.add(category.getId());
            }
        }
        return categoryIdList;
    }

    /**
     * 递归算法，算出子节点
     */
    private Set<Category> findChildCategory(Set<Category> categorySet, Long categoryId) {
        Category category = baseMapper.selectById(categoryId);
        if (category != null)
            categorySet.add(category);
        //查找子节点，递归算法一点要有一个退出条件
        List<Category> categoryList = baseMapper.selectCategoryChildrenByParentId(categoryId);
        for (Category categoryNewest : categoryList) {
            findChildCategory(categorySet, categoryNewest.getId());
        }
        return categorySet;
    }

}
