package wang.redbean.blog.utils;

import wang.redbean.blog.article.entity.vo.ResultVo;

/**
 * 封装http返回数据格式
 */
public class ResultVoUtil {

    /**
     * 请求成功格式
     * @param object
     * @return
     */
    public static ResultVo success(Object object){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(object);
        return  resultVo;
    }

    /**
     * 返回成功，但是具体内容为空的格式
     * @return
     */
    public static ResultVo success(){
        return success(null);
    }

    /**
     * 请求失败格式
     * @param code
     * @param msg
     * @return
     */
    public static ResultVo error(Integer code,String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return  resultVo;
    }
}
