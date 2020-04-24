package wang.redbean.blog.base.entity.response;

import com.alibaba.fastjson.JSON;
import wang.redbean.blog.base.exception.BadRequestException;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;

/**
 * 返回结果类多复用响应类
 * @param <T> 泛型
 */
public class ServerResponse<T> {

    //状态码
    private int status;
    //操作结果
    private String message;
    //响应数据
    private T data;
    /**
     * 私有化构造器
     */
    private ServerResponse(){
    }

    private ServerResponse(int status, T data) {
        this.status=status;
        this.data = data;
    }

    private ServerResponse(int status, String  message){
        super();
        this.status=status;
        this. message= message;
    }

    private ServerResponse(int status, String message, T data){
        this.status=status;
        this.message= message;
        this.data=data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    /**
     *  操作成功
     * @param <T> 返回的数据类型
     * @return 返回this
     */
    public static <T> ServerResponse<T> success(){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc());
    }

    /**
     * 操作成功
     * @param  message 自拟定的成功信息
     * @param <T> 返回的数据类型
     * @return 返回this
     */
    public static <T> ServerResponse<T> successMessage(String  message){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), message);
    }

    /**
     * 操作成功
     * @param data 返回的数据
     * @param <T> 返回的数据类型
     * @return 返回this
     */
    public static <T> ServerResponse<T> success(T data){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc(),data);
    }

    /**
     * 操作成功
     * @param  message 自拟定的成功信息
     * @param data 返回的数据
     * @param <T> 返回的数据类型
     * @return 返回this
     */
    public static <T> ServerResponse<T> success(String  message, T data){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), message , data);
    }

    /**
     * 操作失败
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> error(){
        return new ServerResponse<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    /**
     * 操作失败
     * @param errorMessage 自拟定的失败信息
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> error(String errorMessage){
        return new ServerResponse<>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    /**
     * 操作失败
     * @param status 自拟定的状态
     * @param errorMessage 自拟定的失败信息
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> error(int status, String errorMessage){
        return new ServerResponse<>(status,errorMessage);
    }

    public static <T> ServerResponse<T> isSuccess(boolean result){
        if (result)
            return success();
        return error();
    }

    /**
     * 使用response输出JSON
     * @Author Sans
     * @CreateTime 2019/9/28 11:23
     * @Param  resultMap 数据
     * @Return void
     */
    public static void responseJson( ServletResponse response, ServerResponse serverResponse ){
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(JSON.toJSONString(serverResponse));
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }finally{
            if(out!=null){
                out.flush();
                out.close();
            }
        }
    }


    @Override
    public String toString() {
        return "ServerResponse{" +
                "status=" + status +
                ",  message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
