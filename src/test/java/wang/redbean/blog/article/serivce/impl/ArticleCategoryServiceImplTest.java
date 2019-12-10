package wang.redbean.blog.article.serivce.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wang.redbean.blog.article.entity.ArticleCategory;
import wang.redbean.blog.utils.Tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Test
    void deleteByIds(){
        List<Integer> idList = new ArrayList<>();
        idList.add(3);
        idList.add(2);
        Integer result = articleCategoryService.deleteByIds(idList);
        System.out.println("result:"+result);
        Assert.assertNotNull(result);
    }

    @Test
    void removeByIds(){

        List<Integer> idList = new ArrayList<>();
        /*idList.add(1);
        idList.add(2);*/
        boolean result = articleCategoryService.removeByIds(idList);
        Assert.assertNotNull(result);

    }

    @Test
    void updateById(){
        ArticleCategory articleCategory = new ArticleCategory();
        articleCategory.setCategoryId(4);
        articleCategory.setCategoryType(2);
        articleCategory.setCategoryName("趣闻");
        boolean result = articleCategoryService.updateById(articleCategory);
        System.out.println("result:"+result);
        Assert.assertNotNull(result);

    }

    @Test
    void getById(){
        ArticleCategory articleCategory = articleCategoryService.getById(new Integer(1));
        System.out.println("articleCategory:"+articleCategory);
        Assert.assertEquals(new Integer(1),articleCategory.getCategoryId());
    }

    @Test
    void getByType(){
        ArticleCategory articleCategory = articleCategoryService.getByType(2);
        System.out.println("articleCategory:"+articleCategory);
        Assert.assertEquals(new Integer(2),articleCategory.getCategoryType());
    }


    @Test
    void getByName(){
        ArticleCategory articleCategory = articleCategoryService.getByName("笔记");
        System.out.println("articleCategory:"+articleCategory);
        Assert.assertEquals("笔记",articleCategory.getCategoryName());
    }


    @Test
    void getByTime(){
        Date startDate = Tools.StringToDate("2019-12-09 00:00:00");
        Date endDate = Tools.StringToDate("2019-12-10 23:00:00");
        List<ArticleCategory> articleCategoryList = articleCategoryService.getByTime(startDate,endDate);
        for(ArticleCategory articleCategory:articleCategoryList){
            System.out.println("articleCategory:"+articleCategory);
        }
        Assert.assertNotEquals(0,articleCategoryList.size());
    }

    @Test
    void findAll(){
        List<ArticleCategory> articleCategoryList = articleCategoryService.findAll();
        for(ArticleCategory articleCategory:articleCategoryList){
            System.out.println("articleCategory:"+articleCategory);
        }
        Assert.assertNotEquals(0,articleCategoryList.size());
    }
}