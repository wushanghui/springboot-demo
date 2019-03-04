package com.wsh.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author jue
 * @date 2019/3/4 22:14
 * @describe
 */
@Service
public class ScheduledService {

    @Scheduled(cron = "0,1,2,3,4,5 * * * * MON-FRI")
    public void cronTest() {
        System.out.println("cronTest() ....");
    }
}
