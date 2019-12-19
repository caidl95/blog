package wang.redbean.blog.article.serivce.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import wang.redbean.blog.article.entity.ArticleInfo;
import wang.redbean.blog.article.entity.ArticleRecived;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ArticleInfoServiceImplTest{

    private MockHttpServletRequest request;

    @Autowired
    private ArticleInfoServiceImpl articleInfoService;

    @Test
    void save() {
       // ArticleInfo articleInfo = new ArticleInfo();
    }

    @Test
    void insert() {
        /*request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        request.setParameter("articleName","插入测试");
        request.setParameter("articleDescription","插入一条数据");
        request.setParameter("articleIcon","/pic/xxx.jpg");
        request.setParameter("categoryType","1");*/
    //    ArticleRecived articleRecived = new ArticleRecived();
    //    articleRecived.setUserId(1);
     //   articleRecived.setArticleName("插入测试02");
     //   articleRecived.setArticleDescription("这是一条插入数据");
    //    articleRecived.setArticleIcon("/pic/xxx.jpg");
    //    articleRecived.setArticleStatus(0);
    //    articleRecived.setCategoryType(Integer.valueOf(3));
     //   articleRecived.setContentBody("假装是一整篇文章内容。。。");

       // Integer result = articleInfoService.insert(articleRecived,null);
       // System.out.println("result:"+result);
      //  Assert.assertNotEquals(new Integer(0),result);
    }

    @Test
    void deleteByIds() {
       // List<Integer> idList = new ArrayList<>();
       // idList.add(1);
      //  idList.add(2);
     //   idList.add(3);
     //   idList.add(4);
       // Integer result = articleInfoService.deleteByIds(idList);
        //System.out.println("result:"+result);
        //Assert.assertNotEquals(new Integer(-1),result);
    }

    @Test
    void updateInfoById() {
      //  ArticleInfo articleInfo = new ArticleInfo();
     //   articleInfo.setArticleId(5);
     //   articleInfo.setArticleName("修改测试01");
    //    articleInfo.setArticleDescription("这是一条修改测试");
    //    articleInfo.setArticleIcon("/pic/yyy.jpg");

     //   articleInfo.setUserId(2);

     //   Integer result = articleInfoService.updateInfoById(articleInfo);
     //   System.out.println("result:"+result);
     //   Assert.assertEquals(new Integer(1) ,result);
    }

    @Test
    void findAll() {
    }

    @Test
    void getByParam() {
      //  request = new MockHttpServletRequest();
        /*request.setParameter("startTime","2019-12-13");
        request.setParameter("endTime","2019-12-14");*/
      //  ArticleInfo entity = new ArticleInfo();
       // entity.setUserId(2);
      //  List<ArticleInfo> articleInfoList = articleInfoService.getByParam(request,entity);
     //   for(ArticleInfo articleInfo:articleInfoList){
     //       System.out.println("articleInfo:"+articleInfo);
     //   }
        //Assert.assertNotEquals(0,articleInfoList.size());
    }
}