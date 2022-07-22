package com.wushanghui.springboot.amqp;

import com.wushanghui.springboot.amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAmqp15ApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;


    @Test
    public void createExchange(){

        //创建点对点交换器
		amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
		System.out.println("创建完成");

		//创建队列
		amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));

        //创建绑定规则
        //Binding(String destination, DestinationType destinationType, String exchange, String routingKey, Map<String, Object> arguments)
		amqpAdmin.declareBinding(new Binding("amqpadmin.queue",
                Binding.DestinationType.QUEUE,"amqpadmin.exchange",
                "amqp.hello",null));
    }

    /**
     * 1、单播（点对点）
     */
    @Test
    public void directTest() {
        //Message需要自己构造一个;定义消息体内容和消息头
        //rabbitTemplate.send(exchage,routeKey,message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq；
        //rabbitTemplate.convertAndSend(exchage,routeKey,object);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        //rabbitTemplate.convertAndSend("amqpadmin.exchange", "amqp.hello", map);
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("amqpadmin.exchange", "amqp.hello", new Book("西游记", "吴承恩"));

    }

    //接受数据,如何将数据自动的转为json发送出去
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("amqpadmin.queue");
        if (o != null) {
            Book book =  (Book)o;
            System.out.println(book);
        } else {
            System.out.println("队列里没有消息");
        }

    }

    /**
     * 广播
     */
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout","", new Book("红楼梦","曹雪芹"));
    }

}
