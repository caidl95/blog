package wang.redbean.blog.weixin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import wang.redbean.blog.weixin.model.WechatUser;


public interface IWechatService extends IService<WechatUser> {

    WechatUser selectByOpenId( String openId);

}
