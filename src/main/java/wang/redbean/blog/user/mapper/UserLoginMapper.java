package wang.redbean.blog.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import wang.redbean.blog.user.model.UserLogin;
import wang.redbean.blog.user.model.dto.UserLoginDto;

import java.util.List;

/**
 * 登录日志映射接口类
 */
public interface UserLoginMapper extends BaseMapper<UserLogin> {

    List<UserLogin> getAllToStartAndCount(@Param("dto") UserLoginDto dto);

    Integer checkAmount(@Param("dto") UserLoginDto dto);
}
