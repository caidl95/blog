package wang.redbean.blog.base.entity;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BaseQueryCriteria implements Serializable {

    @ApiParam(name="id",value="ID")
    protected Long id ;

    @ApiParam(name="current",value="查询第几页一页")
    protected Long current = 1L;

    @ApiParam(name="size",value="每页多少条数据")
    protected Long size = 10L;

    @ApiParam(name="fromTime",value="查询创建时间格式为：yyyy-MM-dd HH:mm:ss")

    protected String fromTime;

    @ApiParam(name="fromTime",value="fromTime：开始时间 - toTime：结束时间")
    protected String toTime;

    protected Date dFromTime;//yyyy-MM-dd HH:mm:ss

    protected Date dToTime;
}
