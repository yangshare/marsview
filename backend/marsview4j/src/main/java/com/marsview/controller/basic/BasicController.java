package com.marsview.controller.basic;

import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2024/9/27 10:43
 */
public class BasicController {

    /**
     * 参数绑定
     *
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setAutoGrowNestedPaths(true);
        binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
        binder.registerCustomEditor(Long.class, new CustomNumberEditor(Long.class, true));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    public ResultResponse getResponse() {
        return Builder.of(ResultResponse::new).build();
    }

    public ResultResponse getResponse(Object obj) {
        return Builder.of(ResultResponse::new).with(ResultResponse::setData, obj).build();
    }

    public ResultResponse getErrorResponse(String message) {
        return Builder.of(ResultResponse::new).with(ResultResponse::setCode, -1).with(ResultResponse::setMessage,
                message).build();
    }

    public ResultResponse getUpdateResponse(int result, String message) {
        return Builder.of(ResultResponse::new).with(ResultResponse::setCode, result > 0 ? 0 : -1).with(ResultResponse::setMessage,
                result > 0 ? null : message).build();
    }

    public ResultResponse getErrorResponse(int code, String message) {
        return Builder.of(ResultResponse::new).with(ResultResponse::setCode, code).with(ResultResponse::setMessage,
                message).build();
    }


}
