package wang.redbean.blog.article.entity.vo;

import lombok.Data;

/**
 * http请求返回的最外层格式
 */
@Data
public class ResultVo<T> {

    private Integer code;//返回的状态码

    private String msg;//返回的提示信息

    private T Data;//返回的具体内容

}
