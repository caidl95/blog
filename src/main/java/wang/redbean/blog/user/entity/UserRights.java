package wang.redbean.blog.user.entity;


import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

@Data
public class UserRights extends BaseEntity {

    private Integer rightsId;//权限ID

    private String rightsName;//权限名字

    private Integer rightsType;//权限编号

}
