package com.oc.projets.siteemploibatch.scheduled;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduledClass {

    @Autowired
    public JobLauncher jobLauncher;

    @Autowired
    Job processJob;

//    @Scheduled(fixedRate = 50000)
    @Scheduled(fixedRate = 5000)
    public void perform() throws Exception {
        System.out.println("Entrée dans perform");
        JobParameters jobParameters = new JobParametersBuilder().addLong("time",System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(processJob, jobParameters);
    }
}
