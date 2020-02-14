package wang.redbean.blog.core.base.model.dto;

import wang.redbean.blog.core.base.model.param.BaseParam;
import wang.redbean.blog.core.util.DateTimeUtil;
import java.io.Serializable;
import java.util.Date;


/**
 *  Dto基类
 */
public abstract class BaseDto<T extends BaseParam> implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 2537115926482280568L;

    private Integer start;// 开始数据的索引

    private Integer count;// 每一页的数量

    private Date fromTime;//yyyy-MM-dd HH:mm:ss

    private Date toTime;//结束时间

    private T param;//

    public BaseDto() {}

    public BaseDto(T param) {
        this.param = param;
        if ( this.param.getCount() != null)
            this.count =  this.param.getCount();
        else
            this.count = 10;//不传参数默认为10条
        if ( this.param.getStart() != null)
            this.start =  this.param.getStart()-1;//用户提交想要的页数减掉一
        else
            this.start = 0;//不传参数默认为第一页
        this.fromTime = DateTimeUtil.StringToDate( this.param.getFromTime());
        this.toTime = DateTimeUtil.StringToDate( this.param.getToTime());
    }

    public BaseDto(int start, int count, Date fromTime, Date toTime) {
        this.start = start;
        this.count = count;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }
}
