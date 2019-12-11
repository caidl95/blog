package wang.redbean.blog.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import wang.redbean.blog.user.entity.UserLogin;
import wang.redbean.blog.user.entity.dto.UserLoginDto;

import java.util.List;

/**
 * 登录日志映射接口类
 */
public interface UserLoginMapper extends BaseMapper<UserLogin> {

    @Select("getAllToStartAndCount")
    List<UserLogin> getAllToStartAndCount(@Param("dto") UserLoginDto dto);

    @Select("checkAmount")
    Integer checkAmount(@Param("dto") UserLoginDto dto);
}
