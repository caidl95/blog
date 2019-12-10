package wang.redbean.blog.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {

    /**
     * 字符串转日期格式
     * @param str
     * @return
     */
    public static Date StringToDate(String str){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(str);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }
}
