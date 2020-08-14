package xingyu.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import xingyu.constant.ResponseCode;
import xingyu.response.ServerResponse;

@ControllerAdvice

public class MyControllerAdvice {


    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public ServerResponse serviceExceptionHandler(ServiceException se) {
        System.out.println("幂等校验不通过");
        ServerResponse serverResponse=new ServerResponse();
        serverResponse.setStatus(ResponseCode.ERROR.getCode());
        serverResponse.setMsg(se.getMsg());
        return serverResponse;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ServerResponse exceptionHandler(Exception e) {
        ServerResponse serverResponse=new ServerResponse();
        serverResponse.setStatus(ResponseCode.SERVER_ERROR.getCode());
        serverResponse.setMsg(ResponseCode.SERVER_ERROR.getMsg());
        return serverResponse;
    }

}
