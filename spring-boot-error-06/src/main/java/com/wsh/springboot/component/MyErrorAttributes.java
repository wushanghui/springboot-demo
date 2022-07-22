package com.wushanghui.springboot.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * @author：Administrator
 * @date：2019/2/6
 * @describe：给容器中加入我们自己定义的 ErrorAttributes
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
        errorAttributes.put("company", "wsh_company");
        //从请求域中获取我们异常处理器携带的数据
        Map<String, Object> map = (Map<String, Object>) requestAttributes.getAttribute("extra", 0);
        errorAttributes.put("extra", map);
        return errorAttributes;
    }
}
