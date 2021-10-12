package com.oc.projets.siteemploibatch.config;

import com.oc.projets.siteemploibatch.batch.Processor;
import com.oc.projets.siteemploibatch.batch.Reader;
import com.oc.projets.siteemploibatch.batch.Writer;
import com.oc.projets.siteemploibatch.model.Mail;
import com.oc.projets.siteemploibatch.model.Notification;
import com.oc.projets.siteemploibatch.service.TokenService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public JobLauncher jobLauncher;

    @Autowired
    public TokenService tokenService;

    @Value("${batch.mail}")
    public String email;

    @Value("${batch.password}")
    public String password;

    @Value("${batch.url.authenticate}")
    public String urlAuthentication;

    @Value("${batch.url.notifications}")
    public String urlNotifications;

    @Autowired
    public JavaMailSender javaMailSender;

    @Bean
    public Job processJob() {
        return jobBuilderFactory.get("processJob")
                .incrementer(new RunIdIncrementer()).listener(listener())
                .flow(orderStep1()).end().build();
    }

    @Bean Step orderStep1() {
        return stepBuilderFactory.get("orderStep1").<Notification, SimpleMailMessage>chunk(8)
                .reader(new Reader(tokenService,email,password,urlAuthentication,urlNotifications)).processor(new Processor())
                .writer(new Writer(javaMailSender)).build();
    }

    private JobExecutionListener listener() {
        return new JobExecutionListener() {

            @Override
            public void beforeJob(JobExecution jobExecution) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterJob(JobExecution jobExecution) {
                // TODO Auto-generated method stub
                System.out.println("BATCH DONE.");
            }
        };
    }
}
