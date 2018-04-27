package com.shutter.springserver.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DbGarbageCollector {

    @Scheduled(cron = "0 */${collecting.interval.rooms.mins} * * * *")
    private void collectAllExpiredRooms() {
        log.info("Collecting garbage!");
    }

}
