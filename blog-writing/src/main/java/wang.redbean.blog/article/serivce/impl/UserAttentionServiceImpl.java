package wang.redbean.blog.article.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.article.mapper.UserAttentionMapper;
import wang.redbean.blog.article.model.entity.UserAttention;
import wang.redbean.blog.article.model.vo.UserAttentionVo;
import wang.redbean.blog.article.serivce.IUserAttentionService;
import wang.redbean.blog.base.exception.BadRequestException;

import java.util.List;

/**
 * 用户关注业务实现类
 */
@Service
public class UserAttentionServiceImpl extends ServiceImpl<UserAttentionMapper, UserAttention> implements IUserAttentionService {

    @Override
    public boolean save(UserAttention entity) {
        if (entity.getAttentionUserId() == null)
            throw new BadRequestException("需要关注的用户id丢失！");
        return super.save(entity);
    }

    @Override
    public List<UserAttentionVo> getUserAttention(String username) {
       // return baseMapper.selectList(new QueryWrapper<>(UserAttention))
        return null;
    }
}
