package wang.redbean.blog.weixin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.weixin.mapper.WechatMapper;
import wang.redbean.blog.weixin.model.WechatUser;
import wang.redbean.blog.weixin.service.IWechatService;

@Service
public class WechatServiceImpl extends ServiceImpl<WechatMapper, WechatUser> implements IWechatService {

    @Override
    public WechatUser selectByOpenId(String openId) {
        return baseMapper.selectByOpenId(openId);
    }
}
