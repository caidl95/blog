package wang.redbean.blog.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import wang.redbean.blog.core.base.entity.constant.Const;
import wang.redbean.blog.core.base.entity.response.PagingResponse;
import wang.redbean.blog.core.base.exception.BaseException;
import wang.redbean.blog.core.util.FileUtil;
import wang.redbean.blog.core.util.PageUtil;
import wang.redbean.blog.core.util.ParamToDtoUtil;
import wang.redbean.blog.common.entity.Tool;
import wang.redbean.blog.common.entity.dto.ToolDto;
import wang.redbean.blog.common.entity.param.ToolParam;
import wang.redbean.blog.common.entity.vo.ToolVo;
import wang.redbean.blog.common.mapper.ToolMapper;
import wang.redbean.blog.common.service.IToolService;

import java.io.Serializable;
import java.util.List;


@Service
public class ToolServiceImpl extends ServiceImpl< ToolMapper,Tool> implements IToolService {

    @Override
    public boolean save( MultipartFile file, Tool tool) {
        if (StringUtils.isBlank(tool.getToolName()) || StringUtils.isBlank(tool.getToolExplain()) || tool.getCategoryType()==null)
            throw new BaseException("工具名称或工具说明不能为空！");
        tool.setToolUrl(FileUtil.uploadPic( file, Const.ROOT_PATH_TOOL , tool.getToolName()));
        return retBool(baseMapper.insert(tool));
    }

    @Transactional
    @Override
    public boolean removeById(Serializable id) {
        Tool tool = baseMapper.selectById(id);
        boolean result = FileUtil.deleteFile(tool.getToolUrl());
        if (!result)
            throw new BaseException("删除文件失败！");
        return super.removeById(id);
    }

    @Override
    public boolean updateById(Tool entity) {
        if (StringUtils.isBlank(entity.getToolName()) || StringUtils.isBlank(entity.getToolExplain()) || entity.getCategoryType()==null)
            throw new BaseException("工具名称或工具说明不能为空！");
        return super.updateById(entity);
    }

    @Override
    public Tool selectById(Integer toolId) {
        return baseMapper.selectById(toolId);
    }

    @Override
    public PagingResponse search(ToolParam toolParam) {
        //将 param 转换为 dto
        ParamToDtoUtil<ToolParam, ToolDto> paramToDtoUtil = new ParamToDtoUtil<>();
        ToolDto toolDto = paramToDtoUtil.getParamToDto( toolParam, new ToolDto());
        //创建分页类
        PagingResponse<List<ToolVo>> pagingResponse = new PagingResponse<>(new PageUtil( toolDto.getStart(), toolDto.getCount(), baseMapper.checkAmount( toolDto)));
        pagingResponse.setData( baseMapper.search( toolDto));
        return pagingResponse;
    }


}
