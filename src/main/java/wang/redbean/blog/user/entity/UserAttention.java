package wang.redbean.blog.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

/**
 * attention
 */
@Data
@TableName(value = "user_attention")//指定表名
public class UserAttention extends BaseEntity {

    @TableId(value = "attention_id",type = IdType.AUTO)//指定自增策略
    private Integer attentionId;//关注表id
    //若没有开启驼峰命名，或者表中列名不符合驼峰规则，可通过该注解指定数据库表中的列名，exist标明数据表中有没有对应列
    @TableField(value = "user_id",exist = true)
    private Integer userId;//用户ID

    @TableField(value = "attention_user_id",exist = true)
    private Integer attentionUserId;//关注的ID

    @TableField(value = "attention_status",exist = true)
    private Integer attentionStatus;//关注状态，0正常1取消


}
