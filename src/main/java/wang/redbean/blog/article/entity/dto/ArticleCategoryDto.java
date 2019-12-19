package wang.redbean.blog.article.entity.dto;

import lombok.Data;
import wang.redbean.blog.common.base.entity.dto.BaseDto;

@Data
public class ArticleCategoryDto extends BaseDto {

    private Integer categoryId;//类目ID

    private String categoryName;//类目名字

    private Integer categoryType;//类目编号
}
