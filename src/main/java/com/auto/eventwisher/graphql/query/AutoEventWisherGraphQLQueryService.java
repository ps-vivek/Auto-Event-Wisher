package com.auto.eventwisher.graphql.query;


import com.auto.eventwisher.Entities.EventConfig;
import com.auto.eventwisher.Repositories.EventConfigRepository;
import com.auto.eventwisher.models.EventConfigResponse;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class AutoEventWisherGraphQLQueryService implements GraphQLQueryResolver {

    private final EventConfigRepository eventConfigRepository;
    private final ModelMapper modelMapper;

    public List<EventConfigResponse> findAllEvents(){
        List<EventConfigResponse> eventConfigResponses = new ArrayList<>();

        List<EventConfig> eventConfigs = eventConfigRepository.findAll();
        if(!CollectionUtils.isEmpty(eventConfigs)){
            eventConfigs.forEach(events -> {
                log.debug(events.getEventReceiverConfig().getBirthdayInfo().getReceiverBirthDate().toString());
                EventConfigResponse eventConfigResponse = modelMapper.map(events, EventConfigResponse.class);
                eventConfigResponse.setReceiverBirthDate(events.getEventReceiverConfig().getBirthdayInfo().getReceiverBirthDate());
                eventConfigResponses.add(eventConfigResponse);
            });
        }
        return eventConfigResponses;
    }

    public EventConfigResponse findEventById(String id){
        EventConfigResponse eventConfigResponse = new EventConfigResponse();
        Optional<EventConfig> eventConfig = eventConfigRepository.findById(id);
        if(eventConfig.isPresent()){
            eventConfigResponse = modelMapper.map(eventConfig.get(),EventConfigResponse.class);
            eventConfigResponse.setReceiverBirthDate(eventConfig.get().getEventReceiverConfig().getBirthdayInfo().getReceiverBirthDate());
        }
        return  eventConfigResponse;
    }


}
