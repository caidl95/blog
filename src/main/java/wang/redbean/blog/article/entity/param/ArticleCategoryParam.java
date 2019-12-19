package wang.redbean.blog.article.entity.param;

import lombok.Data;
import wang.redbean.blog.common.base.entity.param.BaseParam;

@Data
public class ArticleCategoryParam extends BaseParam {

    private Integer categoryId;//类目ID

    private String categoryName;//类目名字

    private Integer categoryType;//类目编号

}
