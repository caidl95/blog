package wang.redbean.blog.common.util;


import org.apache.commons.lang3.StringUtils;
import wang.redbean.blog.common.base.entity.dto.BaseDto;
import wang.redbean.blog.common.base.entity.param.BaseParam;
import wang.redbean.blog.common.base.exception.BaseException;

import java.text.SimpleDateFormat;

/**
 * param 赋值 dto
 * @param <P>
 * @param <D>
 */
public class ParamToDtoUtil<P extends BaseParam,D extends BaseDto> {

    /**
     *  将共有的Param赋值给Dto
     * @param param
     * @param dto
     * @return
     */
    public D getParamToDto(P param ,D dto){
        if (param.getCount() != null)
            dto.setCount(param.getCount());
        if (param.getStart() != null)
            dto.setStart(param.getStart());
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (StringUtils.isNotBlank(param.getFromTime()))
                dto.setFromTime(dateFormat.parse(param.getFromTime()));
            if (StringUtils.isNotBlank(param.getToTime()))
                dto.setToTime(dateFormat.parse(param.getToTime()));
        } catch (Exception e) {
            throw new BaseException("传入的日期格式有问题，正确格式为：yyyy-MM-dd");
        }
        return dto;
    }
}
