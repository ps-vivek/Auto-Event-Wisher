package com.auto.eventwisher.scheduler;

import com.auto.eventwisher.Entities.EventConfig;
import com.auto.eventwisher.Repositories.EventConfigRepository;
import com.auto.eventwisher.Entities.WeddingAnniversaryInfoDto;
import com.auto.eventwisher.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class EventWisherScheduler {

    private final MessageService messageService;

    private final EventConfigRepository eventConfigRepository;

    @Scheduled(cron = "0 0 8 * * ?")
    public void scheduledMethod() {
        fetchEventsAndSendMessages();
    }

    //Add error handling and aspect based logging
    private void fetchEventsAndSendMessages() {
        long count = eventConfigRepository.count();
        int batchSize = (int) count / 1000;

        for (int i = 0; i <= batchSize; i++) {
            Page<EventConfig> eventConfigs = eventConfigRepository.findAll(PageRequest.of(i, batchSize));

            eventConfigs.getContent().forEach(eventConfig -> {
                if (Objects.nonNull(eventConfig)) {
                    sendAnniversaryWish(eventConfig);
                    sendBirthdayWish(eventConfig);
                }
            });
        }
    }

    private void sendBirthdayWish(EventConfig eventConfig) {
        if (Objects.nonNull(eventConfig.getEventReceiverConfig().getBirthdayInfo())) {
            if (isEventOccuringToday(eventConfig.getEventReceiverConfig().getBirthdayInfo().getReceiverBirthDate())) {
                messageService.sendMessage(eventConfig.getEventReceiverConfig().getBirthdayInfo().getCustomBirthdayWish(), eventConfig.getEventReceiverConfig().getReceiverPhoneNumber());
            }
        }
    }

    private void sendAnniversaryWish(EventConfig eventConfig) {
        if (Objects.nonNull(eventConfig.getEventReceiverConfig().getWeddingAnniversaryInfo())) {
            if (isEventOccuringToday(eventConfig.getEventReceiverConfig().getWeddingAnniversaryInfo().getReceiverAnniversaryDate())) {
                WeddingAnniversaryInfoDto weddingAnniversaryInfo = eventConfig.getEventReceiverConfig().getWeddingAnniversaryInfo();
                weddingAnniversaryInfo.getCustomAnniversaryWish();
                messageService.sendMessage(weddingAnniversaryInfo.getCustomAnniversaryWish(), eventConfig.getEventReceiverConfig().getReceiverPhoneNumber());
            }
        }
    }

    private boolean isEventOccuringToday(LocalDate eventDate) {
        LocalDate currentDate = LocalDate.now();
        return eventDate.getDayOfMonth() == currentDate.getDayOfMonth() && eventDate.getMonth() == currentDate.getMonth();
    }


}
