package com.jnsorn.practice.springbatch.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class ScopeDIJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job simpleJob() {
        return jobBuilderFactory.get("ScopeDIJob")
            .start(simpleStep1())
            .build();
    }

    private final SimpleJobTasklet tasklet;

    public Step simpleStep1() {
        log.info(">>>>> define simpleStep1");
        return stepBuilderFactory.get("simpleStep1")
            .tasklet(tasklet)
            .build();
    }
}
