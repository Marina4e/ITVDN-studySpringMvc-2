package org.mvc.itvdnstudyspringmvc2.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduleService {

    @Scheduled(fixedRate = 2000)
    public void logSmth() {
        log.info("Я живий");
    }
}
