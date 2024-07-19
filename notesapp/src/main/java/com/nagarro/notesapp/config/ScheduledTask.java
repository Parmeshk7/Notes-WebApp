package com.nagarro.notesapp.config;

import com.nagarro.notesapp.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Autowired
    private SchedulerService schedulerService;

    @Scheduled(cron = "0 0 * * * *")
    public void deleteOldNotesJob(){
        schedulerService.deleteOldNotes();
    }


}
