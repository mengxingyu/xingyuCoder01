package xingyu.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import xingyu.customAnnotations.xyIdempotent;
import xingyu.service.TokenService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Package: xingyu.interceptor
 * @ClassName: IdempotenceInterceptor
 * @Author: mengxingyu
 * @Description:
 * @Date: 2020/8/14 13:49
 */
@Component
public class IdempotenceInterceptor implements HandlerInterceptor {
    @Autowired
    private TokenService tokenService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        xyIdempotent annotation = method.getAnnotation(xyIdempotent.class);
        if (annotation != null) {

                System.out.println("系统拦截到需要实现幂等接口的请求");
                tokenService.checkToken(request);// 幂等性校验, 校验通过则放行, 校验失败则抛出异常, 并通过统一异常处理返回友好提示
            System.out.println("幂等校验通过");
        }

        return true;
    }

}
