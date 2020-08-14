package xingyu.customAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Package: xingyu.customAnnotations
 * @ClassName: xyIdempotent
 * @Author: mengxingyu
 * @Description:
 * @Date: 2020/8/14 9:55
 */
@Target({ElementType.METHOD})//表示只能放在方法上
@Retention(RetentionPolicy.RUNTIME)//表示运行时
public @interface xyIdempotent {
}
