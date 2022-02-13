package com.love.lovebackend.services;

import com.love.lovebackend.Entities.EventConfig;
import com.love.lovebackend.Entities.EventSender;
import com.love.lovebackend.Repositories.EventConfigRepository;
import com.love.lovebackend.models.EventConfigDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventWisherService {

    @Autowired
    ModelMapper modelMapper ;

    @Autowired
    EventConfigRepository eventConfigRepo;

    public String addEvent(List<EventConfigDto>  eventConfigDto) {
        eventConfigDto.forEach(event -> {
            EventConfig eventConfig = modelMapper.map(event, EventConfig.class);
            //Add logic to avoid duplicates
            eventConfig.getEventSenderConfig().setUniqueSenderId();
            eventConfig.getEventReceiverConfig().setUniqueReceiverId();
            eventConfigRepo.save(eventConfig);
        });

        return "success";
    }

}
