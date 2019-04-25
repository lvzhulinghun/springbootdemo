package com.example.springbootdemo.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulingTest {
    private static Logger log = LoggerFactory.getLogger(SchedulingTest.class);

    /**
     * 每5秒执行一次
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void scheduler(){
        log.info(">>>>>>>>>>>>> scheduled test... ");
    }
}
