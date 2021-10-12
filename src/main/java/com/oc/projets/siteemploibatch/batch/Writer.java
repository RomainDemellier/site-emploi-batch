package com.oc.projets.siteemploibatch.batch;

import com.oc.projets.siteemploibatch.model.Mail;
import org.springframework.batch.item.ItemWriter;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

public class Writer implements ItemWriter<SimpleMailMessage> {

    private JavaMailSender javaMailSender;

    public Writer(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void write(List<? extends SimpleMailMessage> list) throws Exception {
        for(SimpleMailMessage msg: list) {
            this.javaMailSender.send(msg);
        }
    }
}
