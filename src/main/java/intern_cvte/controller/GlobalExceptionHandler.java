package intern_cvte.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zxy on 2017/8/17.
 * 处理全局异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler()
    @ResponseBody
    String handleException(Exception e){
        return "Exception Deal! " + e.getMessage();
    }
}
