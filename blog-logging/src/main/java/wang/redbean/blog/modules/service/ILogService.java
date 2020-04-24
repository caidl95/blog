package wang.redbean.blog.modules.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;
import wang.redbean.blog.modules.entity.Log;
import wang.redbean.blog.modules.query.LogQueryCriteria;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 */
public interface ILogService extends IService<Log> {

    /**
     * 分页查询
     * 根据日志类型查询
     * @return /
     */
    Object queryAllByPaging(LogQueryCriteria criteria);

    /**
     * 根据日志类型查询 不做分页
     * @param logType 查询条件
     * @return /
     */
    List<Log> queryAllByLogType(String logType);

    /**
     * 查询用户日志
     * @return -
     */
    Object queryAllByUser(LogQueryCriteria criteria);

    /**
     * 保存日志数据
     * @param username 用户
     * @param browser 浏览器
     * @param ip 请求IP
     * @param joinPoint /
     * @param log 日志实体
     */
    @Async
    void save(String username, String browser, String ip, ProceedingJoinPoint joinPoint, Log log);

    /**
     * 查询异常详情
     * @param id 日志ID
     * @return Object
     */
    Object findByErrDetail(Long id);

    /**
     * 导出日志
     * @param logs 待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<Log> logs, HttpServletResponse response) throws IOException;

    /**
     * 删除所有错误日志
     */
    void delAllByError();

    /**
     * 删除所有INFO日志
     */
    void delAllByInfo();
}
