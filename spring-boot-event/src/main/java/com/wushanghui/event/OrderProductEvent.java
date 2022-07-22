package com.wushanghui.event;

import lombok.Data;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @author 吴尚慧
 * @since 2022/7/15 11:22
 */
@Data
@ToString
public class OrderProductEvent extends ApplicationEvent {

    /** 该类型事件携带的信息 */
    private String orderId;



    public OrderProductEvent(Object source, String orderId) {
        super(source);
        this.orderId = orderId;
    }
}
