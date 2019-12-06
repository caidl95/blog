package wang.redbean.blog.common.base.entity.param;

import java.io.Serializable;

/**
 *  Param 基类
 */
public abstract class BaseParam implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -4240382308377617825L;

    private Integer start;      // 开始数据的索引

    private Integer count = 10;  // 每一页的数量

    private String fromTime;//开始时间 yyyy-MM-dd HH:mm:ss

    private String toTime;//结束时间

    public BaseParam(){}

    public BaseParam(int start, int count, String fromTime, String toTime) {
        this.start = start;
        this.count = count;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

}
