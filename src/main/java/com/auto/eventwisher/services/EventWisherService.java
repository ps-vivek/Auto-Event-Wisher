package com.auto.eventwisher.services;

import com.auto.eventwisher.Repositories.EventConfigRepository;
import com.auto.eventwisher.models.EventConfigDto;
import com.auto.eventwisher.Entities.EventConfig;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
            EventConfig save = eventConfigRepo.save(eventConfig);
            eventConfigs.add(save);
        });

        return eventConfigs;
    }

}
