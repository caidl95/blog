package wang.redbean.blog.user.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import wang.redbean.blog.core.base.entity.response.PagingResponse;
import wang.redbean.blog.user.entity.UserLogin;
import wang.redbean.blog.user.entity.param.UserLoginParam;

/**
 * 登录日志业务接口类
 */
public interface IUserLoginService extends IService<UserLogin> {

    PagingResponse search(UserLoginParam userLoginParam);

}
