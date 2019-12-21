package wang.redbean.blog.core.base.entity.constant;

import java.io.Serializable;

/**
 * 常量类
 * @author hy
 *
 */
public class Const implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 5627921966702931353L;

	/**
	 * 用户名存入session的key
	 */
	public static final String SESSION_KEY_USER = "SESSION_KEY_USER_DATA";

	/**
	 * 用户权限存入session的key
	 */
	public static final String SESSION_KEY_USER_GROUP = "SESSION_KEY_USER_GROUP";

	/**
	 * 图形验证码存入session的key
	 */
	public static final String SESSION_KEY_IMAGE = "SESSION_KEY_IMAGE_CODE";

    /**
     * 手机短信的数字key
     */
    public static final String SESSION_KEY_PHONE_CODE = "SESSION_KEY_MOBILE_CODE";

    /**
     * 手机短信的手机号key
     */
    public static final String SESSION_KEY_PHONE = "SESSION_KEY_MOBILE";

	/**
	 *  工具类的存放路径
	 */
	public static final String ROOT_PATH_TOOL = "/file/common";

	/**
	 *  图片的存放路径
	 */
	public static final String ROOT_PATH_IMAGES = "/file/images";

}