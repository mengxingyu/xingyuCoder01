package xingyu.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: xingyu.service
 * @ClassName: TokenService
 * @Author: mengxingyu
 * @Description:
 * @Date: 2020/8/14 10:34
 */
public interface TokenService {
    public String createToken();
    public void checkToken(HttpServletRequest request);
}
