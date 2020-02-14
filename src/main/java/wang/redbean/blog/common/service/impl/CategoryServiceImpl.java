package wang.redbean.blog.common.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import wang.redbean.blog.common.model.Category;
import wang.redbean.blog.common.mapper.CategoryMapper;
import wang.redbean.blog.common.service.ICategoryService;
import wang.redbean.blog.core.base.exception.BaseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements ICategoryService {

    @Override
    public boolean save(Category entity) {
        if (entity.getParentId() == null || StringUtils.isBlank(entity.getCategoryName()))
            throw new BaseException("添加品类参数错误");
        Category result = baseMapper.selectByName(entity.getCategoryName());
        if (result != null)
            throw new BaseException("已有此份类，无法添加");
        if (CollectionUtils.isEmpty(selectCategoryAndChildrenById(entity.getParentId())))
            throw new BaseException("上级分类不存在");
        return super.save(entity);
    }

    @Override
    public List<Category> getChildrenParallelCategory(Integer categoryId) {
        List<Category> categoryList = baseMapper.selectCategoryChildrenByParentId(categoryId);
        if (CollectionUtils.isEmpty(categoryList))
            System.err.println("未找到当前分类的子分类");
        return categoryList;
    }

    @Override
    public List<Integer>  selectCategoryAndChildrenById(Integer categoryId) {
        Set<Category> categorySet =new HashSet();//初始化set
        findChildCategory(categorySet, categoryId);
        List<Integer> categoryIdList = new ArrayList();
        if (categoryId != null) {
            for (Category category : categorySet) {
                categoryIdList.add(category.getCategoryId());
            }
        }
        return categoryIdList;
    }

    /**
     * 递归算法，算出子节点
     */
    private Set<Category> findChildCategory(Set<Category> categorySet, Integer categoryId) {
        Category category = baseMapper.selectById(categoryId);
        if (category != null)
            categorySet.add(category);
        //查找子节点，递归算法一点要有一个退出条件
        List<Category> categoryList = baseMapper.selectCategoryChildrenByParentId(categoryId);
        for (Category categoryNewest : categoryList) {
            findChildCategory(categorySet, categoryNewest.getCategoryId());
        }
        return categorySet;
    }

}
