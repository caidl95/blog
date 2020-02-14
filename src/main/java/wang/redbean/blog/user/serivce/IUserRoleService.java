package wang.redbean.blog.user.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import wang.redbean.blog.user.model.UserRole;

public interface IUserRoleService extends IService<UserRole> {

    boolean saveBatch(Integer userId ,Integer... roleIds);

}
