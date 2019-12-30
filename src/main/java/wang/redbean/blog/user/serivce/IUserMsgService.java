package wang.redbean.blog.user.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import wang.redbean.blog.user.entity.UserMsg;

/**
 * 用户信息业务接口类
 */
public interface IUserMsgService extends IService<UserMsg> {

    /**
     * 根据用户名id获取登录信息
     * @param userId 用户id
     * @return
     */
    UserMsg getByUserId(Integer userId);


}
