package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.redbean.blog.core.base.exception.BaseException;
import wang.redbean.blog.user.entity.UserMsg;
import wang.redbean.blog.user.mapper.UserMsgMapper;
import wang.redbean.blog.user.serivce.IUserLoginService;
import wang.redbean.blog.user.serivce.IUserMsgService;

import java.util.Date;

/**
 * 用户信息业务实现类
 */
@Service
public class UserMsgServiceImpl extends ServiceImpl<UserMsgMapper,UserMsg> implements IUserMsgService {

    @Override
    public boolean save(UserMsg entity) {
        if (entity.getUserId()!=null)
            throw new BaseException("用户id不能为空！");
        //查询是否存在相同的用户名
        UserMsg userMsg = baseMapper.selectByUserId(entity.getUserId());
        if (userMsg != null)
           return updateById(entity);
        return super.save(entity);
    }

    @Override
    public boolean updateById(UserMsg entity) {
        entity.setUpdateTime(new Date());
        //TODO 修改限制待定
        return super.updateById(entity);
    }


    @Override
    public UserMsg getByUserId(Integer userId) {
        return baseMapper.selectByUserId(userId);
    }
}
