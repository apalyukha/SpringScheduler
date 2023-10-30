package com.apalyukha.springscheduler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerTaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerTaskService.class);

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() throws InterruptedException {
        LOGGER.info("scheduleFixedDelayTask: begin");
        Thread.sleep(2000);
        LOGGER.info("scheduleFixedDelayTask: end");
    }
}
