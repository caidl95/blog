package wang.redbean.blog.common.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wang.redbean.blog.core.base.controller.BaseController;
import wang.redbean.blog.core.base.model.response.ServerResponse;
import wang.redbean.blog.common.model.Tool;
import wang.redbean.blog.common.model.param.ToolParam;
import wang.redbean.blog.common.service.IToolService;
import wang.redbean.blog.core.util.FileUtil;
import wang.redbean.blog.core.util.RandomUtil;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/tool")
public class ToolController extends BaseController<IToolService> {

    @PostMapping("/save")
    public ServerResponse save(@RequestParam("file") MultipartFile file, Tool tool, HttpSession session){
        tool.setUserId(getUidFromSession(session));
        boolean result = service.save(file,tool);
        if (result)
            return ServerResponse.createBySuccess("添加成功!");
        return ServerResponse.createByErrorMessage("添加失败！");
    }

    @PostMapping("/delete")
    public ServerResponse delete(Integer toolId){
        boolean result = service.removeById(toolId);
        if (result)
            return ServerResponse.createBySuccess("删除成功！");
        return ServerResponse.createByErrorMessage("删除失败！");
    }

    @PostMapping("/update")
    public ServerResponse update( HttpSession session, Tool tool){
        if (getUidFromSession(session) != tool.getUserId())
            return ServerResponse.createByErrorMessage("无此操作权限！");
        boolean result = service.updateById(tool);
        if (result)
            return ServerResponse.createBySuccess("修改成功！");
        return ServerResponse.createByErrorMessage("修改失败！");
    }

    @GetMapping("/get")
    public ServerResponse getById(Integer toolId){
        return ServerResponse.createBySuccess(service.selectById(toolId));
    }

    @GetMapping("/search")
    public ServerResponse search(ToolParam toolParam){
        return ServerResponse.createBySuccess(service.search(toolParam));
    }

    @GetMapping("/download")
    public byte[] download(HttpServletResponse response, String path) throws IOException {
        String downloadName = RandomUtil.randomSalt();
        String fileName = URLEncoder.encode(downloadName, "utf-8");
        //需要指定两个响应头
        //response.setContentType("image/png");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        return FileUtil.download(path);
    }

}
