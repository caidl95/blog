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
        else
            dto.setCount(10);//不传参数默认为10条
        if (param.getStart() != null)
            dto.setStart(param.getStart()-1);//用户提交想要的页数减掉一
        else
            dto.setStart(0);//不传参数默认为第一页
        dto.setFromTime(DateTimeUtil.StringToDate(param.getFromTime()));
        dto.setToTime(DateTimeUtil.StringToDate(param.getToTime()));
        return dto;
    }
}
