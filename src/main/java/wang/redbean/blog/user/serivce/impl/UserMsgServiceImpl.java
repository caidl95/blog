package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.redbean.blog.common.base.exception.BaseException;
import wang.redbean.blog.common.util.IpUtil;
import wang.redbean.blog.common.util.MD5Util;
import wang.redbean.blog.user.entity.UserLogin;
import wang.redbean.blog.user.entity.UserMsg;
import wang.redbean.blog.user.entity.vo.UserGroupVo;
import wang.redbean.blog.user.entity.vo.UserMsgVo;
import wang.redbean.blog.user.mapper.UserMsgMapper;
import wang.redbean.blog.user.serivce.IUserGroupService;
import wang.redbean.blog.user.serivce.IUserLoginService;
import wang.redbean.blog.user.serivce.IUserMsgService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 用户信息业务实现类
 */
@Service
public class UserMsgServiceImpl extends ServiceImpl<UserMsgMapper,UserMsg> implements IUserMsgService {

    @Autowired
    private IUserLoginService userLoginService;

    @Override
    public boolean save(UserMsg entity) {
        //检查用户名或密码是否为空，为空不做处理
        if (StringUtils.isBlank(entity.getUserName()) ||StringUtils.isBlank(entity.getUserPassword()))
            throw new BaseException("用户名或密码不能为空！");
        //查询是否存在相同的用户名
        Integer rows = baseMapper.checkUserName(entity.getUserName());
        if (rows >= 1)
            throw new BaseException("用户名已被占用，请输入新的后再试！");
        //把用户提交的密码加密
        entity.setUserPassword(MD5Util.encrypt(entity.getUserPassword()));
        return super.save(entity);
    }

    @Override
    public boolean updateById(UserMsg entity) {
        entity.setUpdateTime(new Date());
        //TODO 修改限制待定
        return super.updateById(entity);
    }

    @Override
    public UserMsgVo login(HttpServletRequest request, String userName, String userPassword) {
        if (baseMapper.checkUserName(userName)== 0)
            throw new BaseException("用户名不存在");
        // 密码登录MD5
        UserMsgVo userMsgVo = baseMapper.selectLogin( userName, MD5Util.encrypt(userPassword));
        if (userMsgVo == null)
            throw new BaseException("密码错误");
        if (userMsgVo.getUserStatus() != 0)
            throw new BaseException("账号已失效，请联系管理员！");
        userMsgVo.setUserPassword( StringUtils.EMPTY);//隐藏数据
        //执行成功后插入登录日志
        UserLogin userLogin = new UserLogin();
        userLogin.setUserId(userMsgVo.getUserId());
        userLogin.setLoginIp(IpUtil.getUserIP(request));
        userLoginService.save(userLogin);
        return userMsgVo;
    }

    @Override
    public boolean resetPassword(String passwordOld, String passwordNew, Integer userId) {
        //防止横向越权，要校验一下这个用户的旧密码，一定要指定是这个用户，因为我们会查询一个count（1），如果不知道id，那么结果就是true coint>0
        int resultCount = baseMapper.checkUserPassword(MD5Util.encrypt(passwordOld), userId);
        if (resultCount == 0)
            throw new BaseException("旧密码错误");
        return retBool( baseMapper.updateUserPassword( userId, MD5Util.encrypt(passwordNew)));
    }

}
