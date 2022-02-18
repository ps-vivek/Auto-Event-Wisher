package com.auto.eventwisher.scheduler;

import com.auto.eventwisher.Entities.EventConfig;
import com.auto.eventwisher.Repositories.EventConfigRepository;
import com.auto.eventwisher.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class EventWisherScheduler {

    private final MessageService messageService;

    private final EventConfigRepository eventConfigRepository;

    @Scheduled(cron = "0 0 8 * * ?")
    public void scheduledMethod() {
        //Read from db in paginated way
        //Send a message
        String message = "Read Message From Config";
        String outgoingNumber = "Read number from config";

        //messageService.sendMessage(message,outgoingNumber);
    }

    //Add error handling and aspect based logging
    private void fetchEventsAndSendMessages(){
        long count = eventConfigRepository.count();
        int batchSize = (int)count/1000;

        for(int i=0; i<=batchSize; i++) {
            Pageable paging = PageRequest.of(i, batchSize);
            Page<EventConfig> eventConfigs = eventConfigRepository.findAll(paging);

            for (EventConfig eventConfig : eventConfigs.getContent()) {
                if( Objects.nonNull(eventConfig)){
                    if( Objects.nonNull(eventConfig.getEventReceiverConfig().getWeddingAnniversaryInfo())){
                            //Check whether the current date is anniversary date
                            //If so send message
                    }

                    if( Objects.nonNull(eventConfig.getEventReceiverConfig().getBirthdayInfo())){
                        //Check whether the current date is birthdate
                        //If so send message
                    }
                }

            }

        }
}}
