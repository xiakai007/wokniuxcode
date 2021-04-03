package com.woniu.exception;

import com.woniu.util.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        return R.error().message("全局异常");
    }
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        return R.error().message("算数异常");
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    @ResponseBody
    public R error(ArrayIndexOutOfBoundsException e){
        return R.error().message("数组下标越界异常");
    }
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public R error(NullPointerException e){
        return R.error().message("空指针异常");
    }
    @ExceptionHandler(K15Exception.class)
    @ResponseBody
    public R error(K15Exception e){
        //设置K15Exception的错误码code和错误信息msg
        return R.error().message(e.getMsg()).code(e.getCode());
    }
}
