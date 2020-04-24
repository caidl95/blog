package wang.redbean.blog.base.entity.response;
/**
 * 响应状态枚举类
 */
public enum ResponseCode {

    SUCCESS(200,"操作成功"),

    ERROR(555,"操作失败"),

    NO_ACCESS(403,"无权限"),

    NO_LOGIN(401,"未登录");

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
