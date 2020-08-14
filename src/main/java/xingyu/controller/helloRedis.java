package xingyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xingyu.config.RedisConfig;
import xingyu.constant.ResponseCode;
import xingyu.customAnnotations.xyIdempotent;
import xingyu.exception.ServiceException;
import xingyu.response.ServerResponse;
import xingyu.service.TestService;
import xingyu.service.TokenService;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: xingyu.controller
 * @ClassName: helloRedis
 * @Author: mengxingyu
 * @Description:
 * @Date: 2020/8/14 9:56
 */
@RestController
public class helloRedis {
    @Autowired
    TokenService tokenService;
    @Autowired
    TestService testService;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public Object helloRedis(String name){
        redisTemplate.opsForValue().set("name",name+",mxy");
        return redisTemplate.opsForValue().get("name");
    }
    @RequestMapping(value = "/token",method = RequestMethod.GET)
    public String getToken(){
        return tokenService.createToken();
    }

    @xyIdempotent
    @RequestMapping(value = "/testIdempotence",method = RequestMethod.POST)
    public ServerResponse testIdempotence(){
        //事实上内部不需要关心幂等的实现，通过自定义注释就已经实现了幂等
        System.out.println("系统执行业务逻辑完成");
        return testService.doSomething();
    }
}
