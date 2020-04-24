package wang.redbean.blog.utils;

import java.math.BigDecimal;

/**
 * BigDecimal 运算类
 */
public class BigDecimalUtil {

    private BigDecimalUtil(){

    }
    //加
    public static BigDecimal add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }
    public static BigDecimal add(BigDecimal b1,BigDecimal b2){
        return b1.add(b2);
    }

    public static BigDecimal add(BigDecimal b1,double v2){
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }


    //减
    public static BigDecimal sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);
    }

    public static BigDecimal sub(BigDecimal b1,BigDecimal b2){
        return b1.subtract(b2);
    }

    //乘
    public static BigDecimal mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }

    public static BigDecimal mul(double v1,BigDecimal b2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        return b1.multiply(b2);
    }

    public static BigDecimal mul(BigDecimal b1, BigDecimal b2) {
        return b1.multiply(b2);
    }

    //除
    public static BigDecimal div(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,2,BigDecimal.ROUND_HALF_UP);
        //除法除不尽的时候 保留两个小时数 四舍五入
    }
    public static BigDecimal div( BigDecimal b1,BigDecimal b2){
        return b1.divide(b2,2,BigDecimal.ROUND_HALF_UP);
        //除法除不尽的时候 保留两个小时数 四舍五入
    }
}
