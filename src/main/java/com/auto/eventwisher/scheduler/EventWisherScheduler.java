package com.auto.eventwisher.scheduler;

import com.auto.eventwisher.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventWisherScheduler {

    private final MessageService messageService;


    @Scheduled(cron = "0 0 8 * * ?")
    public void scheduledMethod() {
        //Read from db in paginated way
        //Send a message
        String message = "Read Message From Config";
        String outgoingNumber = "Read number from config";

        //messageService.sendMessage(message,outgoingNumber);
    }
}
