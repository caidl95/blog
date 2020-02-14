package wang.redbean.blog.user.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import wang.redbean.blog.user.model.User;

public interface IUserService extends IService<User> {

    /**
     * 注册新的用户
     * @param username 用户名
     * @param password 密码
     * @return  成功或失败
     */
    boolean reg(String username,String password);

    /**
     *  登录
     * @param userName 用户名
     * @param userPassword 密码
     * @return 用户信息
     */
    User login(String userName, String userPassword, String loginIp);

    /**
     * 重置密码
     * @param passwordOld 旧密码
     * @param passwordNew 新密码
     * @param id 归属者
     * @return 成功或失败
     */
    boolean resetPassword(String passwordOld, String passwordNew, Integer id);
}
