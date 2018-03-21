package com.springboot.demo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.nio.file.FileSystem;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTest {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    Configuration configuration;

    //简单邮件测试
    @Test
    public void sendMailTest() throws Exception{
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dxf767808421@163.com");
        message.setTo("dxf767808421@163.com");
        message.setSubject("Test Mail");
        message.setText("Test Hello springboot-mail");
        mailSender.send(message);
    }

    //带附件邮件测试
    @Test
    public void sendAttachmentMail() throws Exception{
        MimeMessage mailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage,true);
        helper.setFrom("dxf767808421@163.com");
        helper.setTo("dxf767808421@163.com");
        helper.setSubject("Test Attachment");
        helper.setText("Test Hello",true);
        FileSystemResource file = new FileSystemResource("C:\\Users\\Avatar\\Pictures\\mailtest.jpg");
        helper.addInline("test",file);
        mailSender.send(mailMessage);
    }

    //模板邮件测试
    @Test
    public void sendTemplateMail() throws Exception{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setFrom("dxf767808421@163.com");
        helper.setTo("dxf767808421@163.com");
        helper.setSubject("Test Template");
        Map<String,Object> map = new HashMap<>();
        map.put("username","alien");
        Template t = configuration.getTemplate("test.ftl"); // freeMarker template
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t,map);
        helper.setText("Test Hello TemplateMail" + text,true);
        mailSender.send(mimeMessage);
    }
}
