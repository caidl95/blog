package wang.redbean.blog.modules.query;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import wang.redbean.blog.base.entity.BaseQueryCriteria;

/**
 * 日志查询类
 * @author Zheng Jie
 * @date 2019-6-4 09:23:07
 */

@Getter
@Setter
@ToString
public class LogQueryCriteria extends BaseQueryCriteria {

    String logType;


    String username;
}
