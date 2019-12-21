package wang.redbean.blog.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import wang.redbean.blog.common.entity.Tool;
import wang.redbean.blog.common.entity.dto.ToolDto;
import wang.redbean.blog.common.entity.vo.ToolVo;
import java.util.List;

public interface ToolMapper extends BaseMapper<Tool> {

    Integer checkAmount( @Param("dto") ToolDto dto);

    List<ToolVo> search(@Param("dto") ToolDto dto);

}
