package com.auto.eventwisher.graphql.query.resolver;


import com.auto.eventwisher.Entities.EventConfig;
import com.auto.eventwisher.Repositories.EventConfigRepository;
import com.auto.eventwisher.models.EventConfigDto;
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

    public List<String> findAllEvents(){
        List<String> savedEventConfigIds = new ArrayList<>();
        List<EventConfig> eventConfigs = eventConfigRepository.findAll();
        if(!CollectionUtils.isEmpty(eventConfigs)){
            savedEventConfigIds =eventConfigs.stream().map(EventConfig::getId).collect(Collectors.toList());
        }
        return savedEventConfigIds;
    }


}
