package wang.redbean.blog.common.base.entity.dto;

import java.io.Serializable;
import java.util.Date;


/**
 *  Dto基类
 */
public abstract class BaseDto implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 2537115926482280568L;

    private Integer start;// 开始数据的索引

    private Integer count;// 每一页的数量

    private Date fromTime;//yyyy-MM-dd HH:mm:ss

    private Date toTime;//结束时间

    public BaseDto() {}

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
