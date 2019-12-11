package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import wang.redbean.blog.common.base.exception.BaseException;
import wang.redbean.blog.user.entity.UserAttention;
import wang.redbean.blog.user.entity.vo.UserAttentionVo;
import wang.redbean.blog.user.mapper.UserAttentionMapper;
import wang.redbean.blog.user.serivce.IUserAttentionService;

import java.util.List;

/**
 * 用户关注业务实现类
 */
@Service
public class UserAttentionServiceImpl extends ServiceImpl<UserAttentionMapper, UserAttention> implements IUserAttentionService {

    @Override
    public boolean save(UserAttention entity) {
        if (entity.getAttentionUserId() == null)
            throw new BaseException("需要关注的用户id丢失！");
        entity.setAttentionStatus(0);
        return super.save(entity);
    }

    @Override
    public List<UserAttentionVo> getUserAttention(Integer userId) {
        return baseMapper.getUserAttention(userId);
    }
}
