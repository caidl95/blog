package wang.redbean.blog;

import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wang.redbean.blog.user.entity.UserGroup;
import wang.redbean.blog.user.entity.UserMsg;
import wang.redbean.blog.user.mapper.UserGroupMapper;
import wang.redbean.blog.user.mapper.UserMsgMapper;
import wang.redbean.blog.user.serivce.IUserMsgService;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private UserGroupMapper mapper;

    @Autowired
    IUserMsgService service;

    @Test
    void contextLoads() {
     /*  UserMsg userMsg = new UserMsg();
        userMsg.setUserName("caidl955");
        userMsg.setUserPassword("123456");
        System.err.println(service.save(userMsg));*/
        System.err.println(mapper.selectByUserId(1));
    }

}
