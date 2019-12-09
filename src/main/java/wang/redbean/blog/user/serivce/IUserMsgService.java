package wang.redbean.blog.user.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import wang.redbean.blog.user.entity.UserMsg;
import wang.redbean.blog.user.entity.vo.UserMsgVo;

/**
 * 用户信息业务接口类
 */
public interface IUserMsgService extends IService<UserMsg> {

    /**
     *  登录
     * @param userName 用户名
     * @param userPassword 密码
     * @return 用户信息
     */
    UserMsgVo login(String userName, String userPassword);

    /**
     * 重置密码
     * @param passwordOld 旧密码
     * @param passwordNew 新密码
     * @param userId 归属者
     * @return 成功或失败
     */
    boolean resetPassword(String passwordOld, String passwordNew, Integer userId);


}
