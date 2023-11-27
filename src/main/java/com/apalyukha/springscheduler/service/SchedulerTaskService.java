package com.apalyukha.springscheduler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class SchedulerTaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerTaskService.class);

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() throws InterruptedException {
        LOGGER.info("scheduleFixedDelayTask: begin");
        Thread.sleep(2000);
        LOGGER.info("scheduleFixedDelayTask: end");
    }

    @Scheduled(fixedRate = 3000)
    public void scheduleFixedRateTask() throws InterruptedException {
        LOGGER.info("scheduleFixedRateTask: begin");
        Thread.sleep(1000);
        LOGGER.info("scheduleFixedRateTask: end");
    }

    // run in different threads
    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
        LOGGER.info("scheduleFixedRateTaskAsync: begin");
        Thread.sleep(3000);
        LOGGER.info("scheduleFixedRateTaskAsync: end");
    }

    // initialDelay
    @Scheduled(fixedDelay = 1000, initialDelay = 10000)
    public void scheduleFixedRateWithInitialDelayTask() throws InterruptedException {
        LOGGER.info("scheduleFixedRateWithInitialDelayTask: begin");
        Thread.sleep(3000);
        LOGGER.info("scheduleFixedRateWithInitialDelayTask: end");
    }

    @Scheduled(cron = "0 * * * * ?", zone = "Europe/Kyiv")
    public void scheduleCronExpressionTask() throws InterruptedException {
        LOGGER.info("scheduleCronExpressionTask: begin");
        Thread.sleep(3000);
        LOGGER.info("scheduleCronExpressionTask: end");
    }

    @Scheduled(fixedDelayString = "${task.fixed.delay.millis}")
    public void scheduleFixedDelayParametrizedTask() throws InterruptedException {
        LOGGER.info("scheduleFixedDelayParametrizedTask: begin");
        Thread.sleep(2000);
        LOGGER.info("scheduleFixedDelayParametrizedTask: end");
    }

    @Scheduled(fixedRateString = "${task.fixed.rate.millis}")
    public void scheduleFixedRateParametrizedTask() throws InterruptedException {
        LOGGER.info("scheduleFixedRateParametrizedTask: begin");
        Thread.sleep(2000);
        LOGGER.info("scheduleFixedRateParametrizedTask: end");
    }

    @Scheduled(cron = "${task.cron.expression}")
    public void scheduleCronExpressionParametrizedTask() throws InterruptedException {
        LOGGER.info("scheduleCronExpressionParametrizedTask: begin");
        Thread.sleep(2000);
        LOGGER.info("scheduleCronExpressionParametrizedTask: end");
    }
}
