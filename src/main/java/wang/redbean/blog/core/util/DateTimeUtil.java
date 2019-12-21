package wang.redbean.blog.core.util;

import org.apache.commons.lang3.StringUtils;
import wang.redbean.blog.core.base.exception.BaseException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by geely
 */
public class DateTimeUtil {

    /**
     * 字符串转日期格式
     * @param str
     * @return
     */
    public static Date StringToDate(String str){
        Date date;
        if(StringUtils.isBlank(str)){
           return null;
        }else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = sdf.parse(str);
            }catch (ParseException e){
                throw new BaseException("传入的日期格式有问题，正确格式为：yyyy-MM-dd");
            }
        }
        return date;
    }


}
