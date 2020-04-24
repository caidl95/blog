package wang.redbean.blog.modules.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import wang.redbean.blog.base.controller.BaseController;
import wang.redbean.blog.base.entity.response.ServerResponse;
import wang.redbean.blog.log.Log;
import wang.redbean.blog.modules.query.LogQueryCriteria;
import wang.redbean.blog.modules.service.ILogService;
import wang.redbean.blog.utils.SecurityUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 日志控制器类
 */
@RestController
@RequestMapping("/api/logs")
@Api(tags = "监控：日志管理")
public class LogController extends BaseController<ILogService,wang.redbean.blog.modules.entity.Log> {

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void download(HttpServletResponse response) throws IOException {
        baseService.download(baseService.queryAllByLogType("INFO"), response);
    }

    @Log("导出错误数据")
    @ApiOperation("导出错误数据")
    @GetMapping(value = "/error/download")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void errorDownload(HttpServletResponse response) throws IOException {
        baseService.download(baseService.queryAllByLogType("ERROR"), response);
    }

    @GetMapping("/info")
    @ApiOperation("日志查询")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ServerResponse getLogs(LogQueryCriteria criteria){
        criteria.setLogType("INFO");
        return ServerResponse.success(baseService.queryAllByPaging(criteria));
    }

    @GetMapping(value = "/error")
    @ApiOperation("错误日志查询")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ServerResponse getErrorLogs(LogQueryCriteria criteria){
        criteria.setLogType("ERROR");
        return ServerResponse.success(baseService.queryAllByPaging(criteria));
    }

    @GetMapping(value = "/user")
    @ApiOperation("用户日志查询")
    public ServerResponse getUserLogs(LogQueryCriteria criteria){
        criteria.setLogType("INFO");
        criteria.setUsername(SecurityUtils.getUsername());
        return ServerResponse.success(baseService.queryAllByUser(criteria));
    }


    @GetMapping(value = "/{id}/error")
    @ApiOperation("日志异常详情查询")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ServerResponse getErrorLogs(@PathVariable Long id){
        return ServerResponse.success(baseService.findByErrDetail(id));
    }

    @DeleteMapping(value = "/del/error")
    @Log("删除所有ERROR日志")
    @ApiOperation("删除所有ERROR日志")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ServerResponse delAllByError(){
        baseService.delAllByError();
        return ServerResponse.success();
    }

    @DeleteMapping(value = "/del/info")
    @Log("删除所有INFO日志")
    @ApiOperation("删除所有INFO日志")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ServerResponse delAllByInfo(){
        baseService.delAllByInfo();
        return ServerResponse.success();
    }
}
