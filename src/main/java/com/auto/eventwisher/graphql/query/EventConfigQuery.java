package com.auto.eventwisher.graphql.query;


import com.auto.eventwisher.Entities.EventConfig;
import com.auto.eventwisher.Repositories.EventConfigRepository;
import com.auto.eventwisher.models.EventConfigDto;
import com.auto.eventwisher.models.EventConfigResponse;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EventConfigQuery implements GraphQLQueryResolver {
    private final EventConfigRepository eventConfigRepository;
    private final ModelMapper modelMapper;

    public List<EventConfigResponse> findAllEvents(){
        List<EventConfigResponse> eventConfigResponses = new ArrayList<>();
        List<EventConfig> eventConfigs = eventConfigRepository.findAll();
        if(!CollectionUtils.isEmpty(eventConfigs)){
            eventConfigs.forEach(events -> {
                eventConfigResponses.add(modelMapper.map(events,EventConfigResponse.class));
            });
        }
        return eventConfigResponses;
    }


}
