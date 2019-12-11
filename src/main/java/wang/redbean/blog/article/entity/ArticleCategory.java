package wang.redbean.blog.article.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 文章类目实体类
 */
/*@DynamicUpdate          //自动更新时间*/
@Data
@TableName("article_category")
public class ArticleCategory extends BaseEntity {

    @TableId(value = "category_id" , type = IdType.AUTO)
    private Integer categoryId;//类目ID


    private String categoryName;//类目名字

    private Integer categoryType;//类目编号

    private Date createTime;//创建时间

    private Date updateTime;//修改时间

}
