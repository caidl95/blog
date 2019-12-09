package wang.redbean.blog.article.serivce.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wang.redbean.blog.article.entity.ArticleCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
class ArticleCategoryServiceImplTest {

    @Autowired
    private ArticleCategoryServiceImpl articleCategoryService;

    @Test
    void save() {

        ArticleCategory articleCategory = new ArticleCategory();
        articleCategory.setCategoryName("笔记");
        articleCategory.setCategoryType(1);
        boolean result = articleCategoryService.save(articleCategory);
        Assert.assertNotNull(result);

    }
}