package wang.redbean.blog.user.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wang.redbean.blog.core.base.model.response.PagingResponse;
import wang.redbean.blog.core.util.PageUtil;
import wang.redbean.blog.user.model.UserLogin;
import wang.redbean.blog.user.model.dto.UserLoginDto;
import wang.redbean.blog.user.model.param.UserLoginParam;
import wang.redbean.blog.user.mapper.UserLoginMapper;
import wang.redbean.blog.user.serivce.IUserLoginService;

import java.util.List;

/**
 * 登录日志业务实现类
 */
@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper ,UserLogin> implements IUserLoginService {

    @Override
    public PagingResponse search(UserLoginParam userLoginParam) {
        //将 param 转换为 dto
        UserLoginDto userLoginDto = new UserLoginDto(userLoginParam);
        //创建分页类
        PagingResponse<List<UserLogin>> pagingResponse = new PagingResponse<>(new PageUtil( userLoginDto.getStart(), userLoginDto.getCount(), baseMapper.checkAmount( userLoginDto)));
        pagingResponse.setData( baseMapper.getAllToStartAndCount( userLoginDto));
        return pagingResponse;
    }
}
