package wang.redbean.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wang.redbean.blog.user.entity.param.UserLoginParam;
import wang.redbean.blog.user.serivce.IUserLoginService;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private IUserLoginService service;


    @Test
    void contextLoads() {
       // System.err.println(service.getAllToStartAndCount(new UserLoginParam()));
    }

}
