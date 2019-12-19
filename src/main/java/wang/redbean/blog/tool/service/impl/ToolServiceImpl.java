package wang.redbean.blog.tool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.tool.entity.Tool;
import wang.redbean.blog.tool.mapper.ToolMapper;
import wang.redbean.blog.tool.service.IToolService;

@Service
public class ToolServiceImpl extends ServiceImpl< ToolMapper,Tool> implements IToolService {


}
