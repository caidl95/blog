package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.common.base.entity.response.PagingResponse;
import wang.redbean.blog.common.util.ParamToDtoUtil;
import wang.redbean.blog.user.entity.UserLogin;
import wang.redbean.blog.user.entity.dto.UserLoginDto;
import wang.redbean.blog.user.entity.param.UserLoginParam;
import wang.redbean.blog.user.mapper.UserLoginMapper;
import wang.redbean.blog.user.serivce.IUserLoginService;

import java.util.List;

/**
 * 登录日志业务实现类
 */
@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper ,UserLogin> implements IUserLoginService {


    @Override
    public PagingResponse getAllToStartAndCount(UserLoginParam userLoginParam) {
        //将 param 转换为 dto
        ParamToDtoUtil<UserLoginParam, UserLoginDto> paramToDtoUtil = new ParamToDtoUtil<>();
        UserLoginDto userLoginDto = paramToDtoUtil.getParamToDto(userLoginParam,new UserLoginDto());
        //创建分页类
        PagingResponse<UserLogin> pagingResponse = new PagingResponse<>();
        pagingResponse.setData((UserLogin) baseMapper.getAllToStartAndCount(userLoginDto));

        return null;
    }
}
