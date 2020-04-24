package wang.redbean.blog.weixin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wang.redbean.blog.weixin.model.WechatUser;

@Mapper
public interface WechatMapper extends BaseMapper<WechatUser> {

    WechatUser selectByOpenId(String openId);

}
