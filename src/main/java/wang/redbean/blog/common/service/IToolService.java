package wang.redbean.blog.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;
import wang.redbean.blog.core.base.model.response.PagingResponse;
import wang.redbean.blog.common.model.Tool;
import wang.redbean.blog.common.model.param.ToolParam;

public interface IToolService extends IService<Tool> {

    boolean save(MultipartFile file, Tool tool);

    Tool selectById(Integer toolId);

    PagingResponse search(ToolParam toolParam);
}
