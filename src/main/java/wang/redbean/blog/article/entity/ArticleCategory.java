package wang.redbean.blog.article.entity;

import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

import javax.persistence.Entity;
import java.util.Date;

/**
 * 文章类目实体类
 */
/*@DynamicUpdate          //自动更新时间*/
@Data
@Entity
public class ArticleCategory extends BaseEntity {

    private Integer categoryId;//类目ID

    private String categoryName;//类目名字

    private Integer categoryType;//类目编号

    private Date createTime;//创建时间

    private Date updateTime;//修改时间

}
