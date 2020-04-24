package wang.redbean.blog.base.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.nio.file.AccessDeniedException;
import java.util.Objects;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import wang.redbean.blog.base.entity.response.ServerResponse;
import wang.redbean.blog.base.exception.BadRequestException;
import wang.redbean.blog.base.exception.EntityExistException;
import wang.redbean.blog.base.exception.EntityNotFoundException;
import wang.redbean.blog.utils.ThrowableUtil;

/**
 * 异常处理类
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有不可知的异常
     */
    @ExceptionHandler(Throwable.class)
    public ServerResponse handleException(Throwable e){
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        return ServerResponse.error(e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ServerResponse httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        log.error(e.getMessage());
        return ServerResponse.error(e.getMessage());
    }

    /**
     * 权限异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ServerResponse accessDeniedException(AccessDeniedException e){
        log.error(e.getMessage());
        return ServerResponse.error(e.getMessage()+",权限不够");
    }

    /**
     * BadCredentialsException
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ServerResponse badCredentialsException(BadCredentialsException e){
        log.error(e.getMessage());
        return ServerResponse.error(e.getMessage());
    }

    /**
     * 处理自定义异常
     */
	@ExceptionHandler(value = BadRequestException.class)
	public ServerResponse badRequestException(BadRequestException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        return ServerResponse.error(e.getStatus(),e.getMessage());
	}

    /**
     * 处理 EntityExist
     */
    @ExceptionHandler(value = EntityExistException.class)
    public ServerResponse entityExistException(EntityExistException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        return ServerResponse.error(e.getMessage());
    }

    /**
     * 处理 EntityNotFound
     */
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ServerResponse entityNotFoundException(EntityNotFoundException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        return ServerResponse.error(NOT_FOUND.value(),e.getMessage());
    }

    /**
     * 处理所有接口数据验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ServerResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        String[] str = Objects.requireNonNull(e.getBindingResult().getAllErrors().get(0).getCodes())[1].split("\\.");
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        String msg = "不能为空";
        if(msg.equals(message)){
            message = str[1] + ":" + message;
        }
        return  ServerResponse.error(message);
    }

}
