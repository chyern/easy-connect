package chenyudan.annotation.method;


import chenyudan.enums.HttpMethod;
import chenyudan.enums.MediaType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: TODO
 *
 * @author chenyu
 * @since 2021/7/20
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {

    /**
     * 请求路径
     */
    String value();

    /**
     * 方法类型
     */
    HttpMethod httpMethod();

    /**
     * 请求类型
     */
    MediaType mediaType() default MediaType.JSON;
}
