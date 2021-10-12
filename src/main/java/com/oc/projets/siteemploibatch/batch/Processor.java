package com.oc.projets.siteemploibatch.batch;

import com.oc.projets.siteemploibatch.model.Notification;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.mail.SimpleMailMessage;

public class Processor implements ItemProcessor<Notification, SimpleMailMessage> {

    @Override
    public SimpleMailMessage process(Notification notification) throws Exception {
        SimpleMailMessage msg = new SimpleMailMessage();
        String destinatiare = notification.getUtilisateur().getEmail();
        String subject = "";
        String text = "";
        msg.setTo(destinatiare);
        msg.setSubject(subject);
        msg.setText(text);
        return msg;
    }
}
