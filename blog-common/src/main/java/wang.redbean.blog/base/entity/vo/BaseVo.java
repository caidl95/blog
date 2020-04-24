package wang.redbean.blog.base.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class BaseVo<T> {
    //当前页
    protected Long current = 1L;
    //每页个数
    protected Long size = 10L;
    //总数
    protected Long total;
    //总页数
    protected Long pages;
    //是否有上一页true为有
    protected boolean isHasPrevious ;
    //是否有下一页true为有
    protected boolean isHasNext;
    //数据
    protected List<T> data ;

    public BaseVo() {}

    public BaseVo(Long current, Long size, Long total ,List<T> data) {
        this.current = current;
        this.size = size;
        this.total = total;
        this.pages = getPages();
        this.data = data;
        this.isHasNext =  this.isHasNext();
        this.isHasPrevious =  this.isHasPrevious();
    }

    public BaseVo(Long current, Long size, Long total , Long pages ,List<T> data) {
        this.current = current;
        this.size = size;
        this.total = total;
        this.pages =  pages;
        this.data = data;
        this.isHasNext =  this.isHasNext();
        this.isHasPrevious =  this.isHasPrevious();
    }

    /**
     * 判断是否有上一页
     * 当起始页小于或等于总页数则无上一页
     * @return
     */
    public boolean isHasPrevious(){
        if (current <= pages)
            return false;
        return true;
    }

    /**
     * 判断是否有下一页
     * 如果当前页大于或等于总页数则肯定无下一页
     */
    public boolean isHasNext(){
        if (current >= pages)
            return false;
        return true;
    }


    public long getPages() {
        if (this.getSize() == 0L) {
            return 0L;
        } else {
            long pages = this.getTotal() / this.getSize();
            if (this.getTotal() % this.getSize() != 0L) {
                ++pages;
            }

            return pages;
        }
    }
}
