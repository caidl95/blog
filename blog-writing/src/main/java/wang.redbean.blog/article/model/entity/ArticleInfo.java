package wang.redbean.blog.article.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import wang.redbean.blog.base.entity.BaseEntity;

/**
 * 文章详情实体类
 */

@Getter
@Setter
@TableName("article_info")
public class ArticleInfo extends BaseEntity {

    @TableField("username")
    protected String username;//用户ID

    @TableField("article_name")
    protected String articleName;//文章标题

    @TableField("article_description")
    protected String articleDescription;//文章简介

    @TableField("status")
    protected Integer status = 0;//文章状态，0正常1作废

    @TableField("article_icon")
    protected String  articleIcon;//文章图片

    @TableField("category_type")
    protected Integer categoryType;//文章类目编号

}
