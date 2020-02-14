package wang.redbean.blog.article.entity.dto;

import lombok.Data;
import wang.redbean.blog.article.entity.param.ArticleCategoryParam;
import wang.redbean.blog.core.base.model.dto.BaseDto;

@Data
public class ArticleCategoryDto extends BaseDto<ArticleCategoryParam> {

    private Integer categoryId;//类目ID

    private String categoryName;//类目名字

    private Integer categoryType;//类目编号

    public ArticleCategoryDto(ArticleCategoryParam param) {
        super(param);
    }
}
