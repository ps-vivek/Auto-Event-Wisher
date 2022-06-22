package com.auto.eventwisher.graphql.query;


import com.auto.eventwisher.Entities.EventConfig;
import com.auto.eventwisher.Repositories.EventConfigRepository;
import com.auto.eventwisher.graphql.exception.CustomMongoException;
import com.auto.eventwisher.graphql.exception.EventConfigNotFoundException;
import com.auto.eventwisher.models.EventConfigResponse;
import com.mongodb.MongoException;
import graphql.kickstart.tools.GraphQLQueryResolver;
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

    public static final String CUSTOM_MONGO_EXCEPTION_MESSAGE = "I am having trouble fetching record from mongo!";
    public static final String CUSTOM_EVENT_NOT_FOUND_MESSAGE = "Unable to find event config";

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
        try{
            Optional<EventConfig> eventConfig = eventConfigRepository.findById(id);
            if(eventConfig.isPresent()){
                eventConfigResponse = modelMapper.map(eventConfig.get(),EventConfigResponse.class);
                eventConfigResponse.setReceiverBirthDate(eventConfig.get().getEventReceiverConfig().getBirthdayInfo().getReceiverBirthDate());
            }else{
                throw new EventConfigNotFoundException(CUSTOM_EVENT_NOT_FOUND_MESSAGE,"id");
            }
        }catch(Exception ex){
            throw new CustomMongoException(CUSTOM_MONGO_EXCEPTION_MESSAGE);
        }
        return  eventConfigResponse;
    }


}
