package wang.redbean.blog.article.serivce.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wang.redbean.blog.article.entity.ArticleContent;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ArticleContentServiceImplTest {

    @Autowired
    private ArticleContentServiceImpl articleContentService;

    @Test
    void updateByArticleId() {
      //  ArticleContent articleContent  = new ArticleContent();
     //   articleContent.setArticleId(9);
     //   articleContent.setContentBody("假装是修改过后的文章");
       // Integer result = articleContentService.updateByArticleId(articleContent);
        //System.out.println("result:"+result);
      //  Assert.assertNotEquals(new Integer(-1),result);
    }

    @Test
    void getByArticleId() {
      //  Integer articleId = 9;
       // ArticleContent articleContent = articleContentService.getByArticleId(articleId);
       // System.out.println("result:"+articleContent);
      //  Assert.assertEquals(new Integer(9),articleContent.getArticleId());
    }
}