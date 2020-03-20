package wang.redbean.blog.weixin.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import wang.redbean.blog.core.base.model.entity.BaseEntity;


/**
 * 微信用户实体类
 */

@Data
@TableName("wechat_user")
public class WechatUser extends BaseEntity {

    @TableId
    private Long id;

    // openId,标识该公众号下面的该用户的唯一Id
    @JsonProperty("openid")
    private String openId;
    // 用户昵称
    @JsonProperty("nickname")
    private String nickName;
    // 性别
    @JsonProperty("sex")
    private int sex;
    // 省份
    @JsonProperty("province")
    private String province;
    // 城市
    @JsonProperty("city")
    private String city;
    // 区
    @JsonProperty("country")
    private String country;
    // 头像图片地址
    @JsonProperty("headimgurl")
    private String headimgurl;
    // 语言
    @JsonProperty("language")
    private String language;
    // 用户权限，这里没什么作用
    @TableField(exist = false)//表示该属性不为数据库表字段，但又是必须使用的。
    @JsonProperty("privilege")
    private String[] privilege;

}
