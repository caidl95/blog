package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import wang.redbean.blog.common.base.exception.BaseException;
import wang.redbean.blog.common.util.MD5Util;
import wang.redbean.blog.user.entity.UserMsg;
import wang.redbean.blog.user.mapper.UserMsgMapper;
import wang.redbean.blog.user.serivce.IUserMsgService;

/**
 * 用户信息业务实现类
 */
@Service
public class UserMsgServiceImpl extends ServiceImpl<UserMsgMapper,UserMsg> implements IUserMsgService {

    @Override
    public boolean save(UserMsg entity) {
        //检查用户名或密码是否为空，为空不做处理
        if (StringUtils.isBlank(entity.getUserName()) ||StringUtils.isBlank(entity.getUserPassword()))
            throw new BaseException("用户名或密码不能为空！");
        //查询是否存在相同的用户名
        Integer rows =baseMapper.checkUserName(entity.getUserName());
        if (rows >= 1)
            throw new BaseException("用户名已被占用，请输入新的后再试！");
        //把用户提交的密码加密
        entity.setUserPassword(MD5Util.encrypt(entity.getUserPassword()));
        return super.save(entity);
    }

    @Override
    public boolean updateById(UserMsg entity) {
        return super.updateById(entity);
    }
}
