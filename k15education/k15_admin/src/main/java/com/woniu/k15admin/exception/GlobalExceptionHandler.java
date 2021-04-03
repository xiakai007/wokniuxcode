package com.woniu.k15admin.exception;


import com.woniu.k15admin.util.ExceptionUtil;
import com.woniu.k15admin.util.R;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message("全局异常");
    }
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message("算数异常");
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    @ResponseBody
    public R error(ArrayIndexOutOfBoundsException e){
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message("数组下标越界异常");
    }
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public R error(NullPointerException e){
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message("空指针异常");
    }
    @ExceptionHandler(K15Exception.class)
    @ResponseBody
    public R error(K15Exception e){
        //设置K15Exception的错误码code和错误信息msg
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message(e.getMsg()).code(e.getCode());
    }
}
