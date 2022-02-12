package com.love.lovebackend.services;

import com.love.lovebackend.Entities.EventConfig;
import com.love.lovebackend.Repositories.EventConfigRepository;
import com.love.lovebackend.models.EventConfigDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventWisherService {

    @Autowired
    ModelMapper modelMapper ;

    @Autowired
    EventConfigRepository eventConfigRepo;

    public String addEvent(EventConfigDto eventConfigDto) {
        EventConfig eventConfig = modelMapper.map(eventConfigDto, EventConfig.class);
        eventConfigRepo.save(eventConfig);
        return "success";
    }

}
