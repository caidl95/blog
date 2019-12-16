package wang.redbean.blog.article.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

/**
 * 文章详情实体类
 */

@Data
@TableName("article_info")
public class ArticleInfo extends BaseEntity {

    @TableId(value = "article_id" , type = IdType.AUTO)
    private Integer articleId;// 文章ID

    private Integer userId;//用户ID

    private String articleName;//文章标题

    private String articleDescription;//文章简介

    private Integer articleStatus;//文章状态，0正常1作废

    private String  articleIcon;//文章图片

    private Integer categoryType;//文章类目编号

}
