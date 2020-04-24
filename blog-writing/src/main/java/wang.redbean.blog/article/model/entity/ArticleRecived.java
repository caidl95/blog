package wang.redbean.blog.article.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 接收文章详情实体类
 */

@Getter
@Setter
@TableName("article_recived")
public class ArticleRecived extends ArticleInfo {


    private Integer articleId;//文章ID

    private String contentBody;//文章正文

}
