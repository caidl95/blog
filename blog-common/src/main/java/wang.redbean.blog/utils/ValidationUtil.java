package wang.redbean.blog.utils;

import cn.hutool.core.util.ObjectUtil;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import wang.redbean.blog.base.exception.BadRequestException;

import java.io.Serializable;

/**
 * 验证工具
 * @author Zheng Jie
 * @date 2018-11-23
 */
public class ValidationUtil {

    /**
     * 验证空为空直接抛异常
     * @param content 需要验证的参数
     * @param explain 异常说明
     */
    public static void isNullByString(String content, String explain){
        if (StringUtils.isBlank(content))
            throw new BadRequestException( explain +"不能为空！");
    }

    /**
     * 验证两个参数有其中一个为空直接抛异常
     * @param content1 需要验证的参数一
     * @param content2 需要验证的参数二
     * @param explain 异常说明
     */
    public static void isNullByString(String content1, String content2, String explain){
        if (StringUtils.isBlank(content1) || StringUtils.isBlank(content2))
            throw new BadRequestException( explain +"不能为空！");
    }


    /**
     * 验证空为空直接抛异常
     * @param num 需要验证的参数
     * @param explain 异常说明
     */
    public static void isNullBySerializable(Serializable num , String explain){
        if (num == null)
            throw new BadRequestException(explain + "不能为空！");
    }

    /**
     * 验证空为空直接抛异常
     * @param num 需要验证的参数
     * @param explain 异常说明
     */
    public static void isNullBySerializable(Serializable num , Long num2,String explain){
        if (num == null || num2 ==null)
            throw new BadRequestException(explain + "不能为空！");
    }

    /**
     * 验证结果是否正常，当不正常时抛异常
     * @param result 需要判断的结果
     * @param explain 异常说明
     */
    public static void isFalse(boolean result, String explain){
        if (!result)
            throw new BadRequestException( explain +"出现未知异常！");
    }


    /**
     * 验证结果是否正常，当正常时抛异常
     * @param result 需要判断的结果
     * @param explain 异常说明
     */
    public static void isTrue(boolean result, String explain){
        if (result)
            throw new BadRequestException(explain);
    }

    /**
     * 验证空
     */
    public static void isNull(Object obj, String entity, String parameter , Object value){
        if(ObjectUtil.isNull(obj)){
            String msg = entity + " 不存在: "+ parameter +" is "+ value;
            throw new BadRequestException(msg);
        }
    }

    /**
     * 验证是否为邮箱
     */
    public static boolean isEmail(String email) {
        return new EmailValidator().isValid(email, null);
    }

    /**
     * 判断
     * @param result
     * @return
     */
    public static boolean retBool(Integer result) {
        return null != result && result >= 1;
    }

}
