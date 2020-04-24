package wang.redbean.blog.modules.service.impl;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;
import wang.redbean.blog.base.entity.vo.BaseVo;
import wang.redbean.blog.modules.entity.Log;
import wang.redbean.blog.modules.mapper.LogMapper;
import wang.redbean.blog.modules.query.LogQueryCriteria;
import wang.redbean.blog.modules.service.ILogService;
import wang.redbean.blog.utils.FileUtil;
import wang.redbean.blog.utils.StringUtils;
import wang.redbean.blog.utils.ValidationUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {


    public BaseVo queryAllByPaging(LogQueryCriteria criteria){
        IPage<Log> userPage = baseMapper.selectPage(new Page<>(criteria.getCurrent(), criteria.getSize())
                ,new QueryWrapper<Log>().eq("log_type",criteria.getLogType()));
        return new BaseVo<>( userPage.getCurrent(), userPage.getSize(), userPage.getTotal(), userPage.getPages(),userPage.getRecords());
    }


    public List<Log> queryAllByLogType(String logType) {
        return baseMapper.selectList(new QueryWrapper<Log>().eq("log_type",logType));
    }

    public Object queryAllByUser(LogQueryCriteria criteria) {
        IPage<Log> logPage = baseMapper.selectPage(new Page<>(criteria.getCurrent(), criteria.getSize())
                ,new QueryWrapper<Log>().eq("log_type",criteria.getLogType()).eq("username",criteria.getUsername()));
        return new BaseVo<>( logPage.getCurrent(), logPage.getSize(), logPage.getTotal(), logPage.getPages(),logPage.getRecords());
    }

    @Override
    public void save(String username, String browser, String ip, ProceedingJoinPoint joinPoint, Log log){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        wang.redbean.blog.log.Log aopLog = method.getAnnotation(wang.redbean.blog.log.Log.class);

        // 方法路径
        String methodName = joinPoint.getTarget().getClass().getName()+"."+signature.getName()+"()";

        StringBuilder params = new StringBuilder("{");
        //参数值
        Object[] argValues = joinPoint.getArgs();
        //参数名称
        String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
        if(argValues != null){
            for (int i = 0; i < argValues.length; i++) {
                params.append(" ").append(argNames[i]).append(": ").append(argValues[i]);
            }
        }
        // 描述
        if (log != null) {
            log.setDescription(aopLog.value());
        }
        assert log != null;
        log.setRequestIp(ip);

        String loginPath = "login";
        if(loginPath.equals(signature.getName())){
            try {
                assert argValues != null;
                username = new JSONObject(argValues[0]).get("username").toString();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        log.setAddress(StringUtils.getCityInfo(log.getRequestIp()));
        log.setMethod(methodName);
        log.setUsername(username);
        log.setParams(params.toString() + " }");
        log.setBrowser(browser);
        baseMapper.insert(log);
    }

    @Override
    public Object findByErrDetail(Long id) {
        Log log = baseMapper.selectOne(new QueryWrapper<Log>().eq("log_type","ERROR").eq("id",id));
        ValidationUtil.isNull( log.getId(),"Log","id", id);
        byte[] details = log.getExceptionDetail();
        return Dict.create().set("exception",new String(ObjectUtil.isNotNull(details) ? details : "".getBytes()));
    }

    @Override
    public void download(List<Log> logs, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (Log log : logs) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("用户名", log.getUsername());
            map.put("IP", log.getRequestIp());
            map.put("IP来源", log.getAddress());
            map.put("描述", log.getDescription());
            map.put("浏览器", log.getBrowser());
            map.put("请求耗时/毫秒", log.getTime());
            map.put("异常详情", new String(ObjectUtil.isNotNull(log.getExceptionDetail()) ? log.getExceptionDetail() : "".getBytes()));
            map.put("创建日期", log.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }

    @Override
    public void delAllByError() {
        baseMapper.delete(new QueryWrapper<Log>().eq("log_type","ERROR"));
    }

    @Override
    public void delAllByInfo() {
        baseMapper.delete(new QueryWrapper<Log>().eq("log_type","INFO"));
    }
}
