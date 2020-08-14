package xingyu.service.impl;

import org.springframework.stereotype.Service;
import xingyu.constant.ResponseCode;
import xingyu.response.ServerResponse;
import xingyu.service.TestService;

/**
 * @Package: xingyu.service.impl
 * @ClassName: TestServiceImpl
 * @Author: mengxingyu
 * @Description:
 * @Date: 2020/8/14 13:40
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public ServerResponse doSomething() {
        ServerResponse serverResponse=new ServerResponse();
        serverResponse.setStatus(ResponseCode.SUCCESS.getCode());
        serverResponse.setMsg("幂等性接口测试完成");
        return serverResponse;
    }
}
