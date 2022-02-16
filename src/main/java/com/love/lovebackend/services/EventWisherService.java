package com.love.lovebackend.services;

import com.love.lovebackend.Entities.EventConfig;
import com.love.lovebackend.Entities.EventSender;
import com.love.lovebackend.Repositories.EventConfigRepository;
import com.love.lovebackend.models.EventConfigDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventWisherService {

    private final ModelMapper modelMapper ;

    private final EventConfigRepository eventConfigRepo;

    public List<EventConfig> addEvent(List<EventConfigDto>  eventConfigDto) {
        List<EventConfig> eventConfigs = new ArrayList<>();
        eventConfigDto.forEach(event -> {
            EventConfig eventConfig = modelMapper.map(event, EventConfig.class);
            //Add logic to avoid duplicates
            eventConfig.setUniqueSenderId();
            eventConfig.setUniqueReceiverId();

            EventConfig save = eventConfigRepo.save(eventConfig);
            eventConfigs.add(save);
        });

        return eventConfigs;
    }

}
