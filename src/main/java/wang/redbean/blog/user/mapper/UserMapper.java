package wang.redbean.blog.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import wang.redbean.blog.user.model.User;

public interface UserMapper extends BaseMapper<User> {

    Integer checkUsername(String username);

    User selectLogin(@Param("username") String username, @Param("password") String password);

    Integer checkPassword(@Param("password") String password, @Param("id") Integer id);

    Integer updateUserPassword(@Param("id") Integer id, @Param("password") String password);
}
