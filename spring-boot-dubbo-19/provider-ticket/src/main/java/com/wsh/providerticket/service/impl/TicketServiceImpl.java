package com.wushanghui.providerticket.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wushanghui.providerticket.service.TicketService;
import org.springframework.stereotype.Component;


@Component
@Service //将服务发布出去
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "《厉害了，我的国》";
    }
}
