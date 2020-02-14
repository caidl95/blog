package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wang.redbean.blog.core.base.model.constant.ConstRole;
import wang.redbean.blog.core.base.exception.BaseException;
import wang.redbean.blog.core.util.MD5Util;
import wang.redbean.blog.user.model.User;
import wang.redbean.blog.user.model.UserLogin;
import wang.redbean.blog.user.model.UserMsg;
import wang.redbean.blog.user.model.UserRole;
import wang.redbean.blog.user.mapper.UserMapper;
import wang.redbean.blog.user.serivce.IUserLoginService;
import wang.redbean.blog.user.serivce.IUserMsgService;
import wang.redbean.blog.user.serivce.IUserRoleService;
import wang.redbean.blog.user.serivce.IUserService;

/**
 * 用户登录业务实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {

    @Autowired
    private IUserLoginService userLoginService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IUserMsgService userMsgService;

    @Transactional
    @Override
    public boolean reg(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password))
            throw new BaseException("用户名或密码不能为空！");
        Integer row = baseMapper.checkUsername(username);
        if (row>=1)
            throw new BaseException("用户名已存在,请重新输入！");
        User user = new User(username,MD5Util.encode(password));//对新增密码加密
        boolean result = super.save(user);
        if (!result)
            throw new BaseException("新增用户时出现未知异常！");
        result = userMsgService.save(new UserMsg(user.getId(),user.getUsername()));
        if (!result)
            throw new BaseException("默认新增用户信息时出现未知异常！");
        result = userRoleService.save(new UserRole(user.getId(), ConstRole.USER_ROLE_USER_ID));
        if (!result)
            throw new BaseException("默认新增用户权限时出现未知异常！");
        return true;
    }

    @Override
    public User login( String username, String password, String loginIp) {
        if (baseMapper.checkUsername(username)== 0)
            throw new BaseException("用户名不存在");
        // 密码登录MD5
        User user = baseMapper.selectLogin( username, MD5Util.encode(password));
        if (user == null)
            throw new BaseException("密码错误");
        user.setPassword( StringUtils.EMPTY);//隐藏数据
        //执行成功后插入登录日志
        userLoginService.save(new UserLogin(user.getId(),loginIp));
        return user;
    }

    @Override
    public boolean resetPassword(String passwordOld, String passwordNew, Integer id) {
        //防止横向越权，要校验一下这个用户的旧密码，一定要指定是这个用户，因为我们会查询一个count（1），如果不知道id，那么结果就是true coint>0
        int resultCount = baseMapper.checkPassword(MD5Util.encode(passwordOld), id);
        if (resultCount == 0)
            throw new BaseException("旧密码错误");
        return retBool( baseMapper.updateUserPassword( id, MD5Util.encrypt(passwordNew)));
    }


}

