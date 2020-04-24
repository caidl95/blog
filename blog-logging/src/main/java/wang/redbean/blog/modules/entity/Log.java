package wang.redbean.blog.modules.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import wang.redbean.blog.base.entity.BaseEntity;

/**
 * 日志记录实体类
 */
@Getter
@Setter
@TableName("log")
public class Log  extends BaseEntity {

    /** 操作用户 */
    @TableField("username")
    private String username;

    /** 描述 */
    @TableField("description")
    private String description;

    /** 方法名 */
    @TableField("method")
    private String method;

    /** 参数 */
    @TableField("params")
    private String params;

    /** 日志类型 */
    @TableField("log_type")
    private String logType;

    /** 请求ip */
    @TableField("request_ip")
    private String requestIp;

    /** 地址 */
    @TableField("address")
    private String address;

    /** 浏览器  */
    @TableField("browser")
    private String browser;

    /** 请求耗时 */
    @TableField("time")
    private Long time;

    /** 异常详细  */
    @TableField("exception_detail")
    private byte[] exceptionDetail;

    public Log(){}

    public Log(String logType, Long time) {
        this.logType = logType;
        this.time = time;
    }
}
