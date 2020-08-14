package xingyu.service.impl;



import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import xingyu.constant.Constants;
import xingyu.constant.ResponseCode;
import xingyu.exception.ServiceException;
import xingyu.service.TokenService;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


/**
 * @Package: xingyu.service
 * @ClassName: tokenService
 * @Author: mengxingyu
 * @Description: token服务
 * @Date: 2020/8/14 10:33
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Override
    public String createToken() {
        try{
            String token = UUID.randomUUID().toString();
            StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append("token:");
            stringBuilder.append(token);
            redisTemplate.opsForValue().set(stringBuilder.toString(),stringBuilder.toString(),1000L);
            boolean notEmpty= StringUtils.isEmpty(token);
            if(!notEmpty){
                return stringBuilder.toString();
          }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void checkToken(HttpServletRequest request) {
            String token = request.getHeader(Constants.TOKEN_NAME);//获取请求头中的token
            if(StringUtils.isBlank(token)){
                token = request.getParameter(Constants.TOKEN_NAME);//获取请求体中的token
                if(StringUtils.isBlank(token)){
                    throw new ServiceException(ResponseCode.ILLEGAL_ARGUMENT.getMsg());
                }
            }
            if(!redisTemplate.hasKey(token)){
                throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
            }
        Boolean delete = redisTemplate.delete(token);
            if(!delete){
                throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
            }

    }
}
