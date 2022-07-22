package com.wushanghui.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads() {
    }

    //测试简单的邮件发送
    @Test
    public void testMail1() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("通知开会");
        mailMessage.setText("今晚7：30 准时开会");
        mailMessage.setTo("wush93@163.com");
        mailMessage.setFrom("550178628@qq.com");
        javaMailSender.send(mailMessage);
    }

    //测试复杂消息邮件发送
    @Test
    public void testMail2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //multipart 是否上传附件
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //邮件设置
        helper.setSubject("通知开会");
        helper.setText("<b style='color:red'>今晚7：30 准时开会</b>", true);
        helper.setTo("wush93@163.com");
        helper.setFrom("550178628@qq.com");
        //上次附件
        helper.addAttachment("1547906924165.jpg", new File("C:\\Users\\jue\\Downloads\\1547906924165.jpg"));
        helper.addAttachment("1547907050136.jpg", new File("C:/Users/jue/Downloads/1547907050136.jpg"));
        javaMailSender.send(mimeMessage);
    }


}
