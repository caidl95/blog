package wang.redbean.blog.user.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import wang.redbean.blog.user.entity.UserGroup;
import wang.redbean.blog.user.entity.vo.UserGroupVo;

import java.util.List;

/**
 * 权限业务接口类
 */
public interface IUserGroupService extends IService<UserGroup> {

    List<UserGroupVo> selectByUserId(Integer userId);
}
