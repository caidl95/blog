package wang.redbean.blog.common.base.entity.enums;
/**
 * 响应状态枚举类
 */
public enum ResponseCode {

	  /**
     * 成功
     */
    SUCCESS(200,"成功"),
    /**
     * 失败
     */
    ERROR(500,"失败");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc){
        this.code=code;
        this.desc=desc;
    }

    public int getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }
}
