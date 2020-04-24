package wang.redbean.blog.base.exception;

import org.springframework.util.StringUtils;

/**
 * 实体类已经存在
 */
public class EntityExistException extends RuntimeException {

    public EntityExistException(Class clazz, String field, String val) {
        super(EntityExistException.generateMessage(clazz.getSimpleName(), field, val));
    }

    private static String generateMessage(String entity, String field, String val) {
        return StringUtils.capitalize(entity) + " with " + field + " "+ val + " existed";
    }
}