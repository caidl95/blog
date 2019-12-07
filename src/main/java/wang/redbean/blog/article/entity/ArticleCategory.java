package wang.redbean.blog.article.entity;

import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

/**
 * 文章类目实体类
 */
@Data
public class ArticleCategory extends BaseEntity {

    private Integer categoryId;//类目ID

    private String categoryName;//类目名字

    private Integer categoryType;//类目编号

}
