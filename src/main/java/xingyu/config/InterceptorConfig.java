package xingyu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xingyu.interceptor.IdempotenceInterceptor;


/**
 * @Package: xingyu.config
 * @ClassName: InterceptorConfig
 * @Author: mengxingyu
 * @Description:
 * @Date: 2020/8/14 14:06
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    IdempotenceInterceptor idempotenceInterceptor;
    @Override

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(idempotenceInterceptor);

    }
}
