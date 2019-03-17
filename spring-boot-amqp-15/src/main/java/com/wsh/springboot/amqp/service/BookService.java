package com.wsh.springboot.amqp.service;

import com.wsh.springboot.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "amqpadmin.queue")
    public void receive(Book book){
        System.out.println("收到消息："+book);
        //收到消息：Book{name='西游记', author='吴承恩'}
    }

    @RabbitListener(queues = "wsh")
    public void receive02(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
        //[B@4316ba82
        //MessageProperties [headers={}, timestamp=null, messageId=null, userId=null, receivedUserId=null, appId=null, clusterId=null, type=null, correlationId=null, correlationIdString=null, replyTo=null, contentType=null, contentEncoding=null, contentLength=0, deliveryMode=null, receivedDeliveryMode=NON_PERSISTENT, expiration=null, priority=null, redelivered=false, receivedExchange=exchange.wsh, receivedRoutingKey=, receivedDelay=null, deliveryTag=2, messageCount=0, consumerTag=amq.ctag-CaCRZaJ-_3OTHcW5Le8voA, consumerQueue=wsh]
    }
}
