package wang.redbean.blog.common.base.entity.response;

import java.io.Serializable;

/**
 * 分页响应类
 * @param <T>
 */
public class PagingResponse<T> implements Serializable {

    private static final long serialVersionUID = 4923590906522614359L;

    private T data;//返回的Vo类

    private int start;// 开始数据的索引

    private int count;// 每一页的数量

    private Integer amount;//总条数

    private boolean isHasPrevious ;//是否有上一页true为有

    private boolean isHasNext;//是否有下一页true为有

    private Integer totalPage;//总页数

    public PagingResponse() {}

    public PagingResponse(T data, int start, int count, Integer amount, boolean isHasPrevious, boolean isHasNext, Integer totalPage) {
        this.data = data;
        this.start = start;
        this.count = count;
        this.amount = amount;
        this.isHasPrevious = isHasPrevious;
        this.isHasNext = isHasNext;
        this.totalPage = totalPage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean isHasPrevious() {
        return isHasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        isHasPrevious = hasPrevious;
    }

    public boolean isHasNext() {
        return isHasNext;
    }

    public void setHasNext(boolean hasNext) {
        isHasNext = hasNext;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PagingResponse{" +
                "data=" + data +
                ", start=" + start +
                ", count=" + count +
                ", amount=" + amount +
                ", isHasPrevious=" + isHasPrevious +
                ", isHasNext=" + isHasNext +
                ", totalPage=" + totalPage +
                '}';
    }
}
