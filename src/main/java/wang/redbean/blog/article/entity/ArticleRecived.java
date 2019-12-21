package wang.redbean.blog.article.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 接收文章详情实体类
 */

@Data
@TableName("article_recived")
public class ArticleRecived extends ArticleInfo {

    @TableId(value = "content_id",type = IdType.AUTO)
    private Integer contentId;//正文ID

    private Integer articleId;//文章ID

    private String contentBody;//文章正文

}
