package com.auto.eventwisher.graphql.mutation;

import com.auto.eventwisher.Entities.EventConfig;
import com.auto.eventwisher.Repositories.EventConfigRepository;
import com.auto.eventwisher.models.EventConfigDto;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.mongodb.MongoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class AutoEventWisherGraphQLMutationService implements GraphQLMutationResolver {

    public static final String EVENT_CONFIG_SAVE_SUCCESS = "Event config save success";
    public static final String EVENT_CONFIG_SAVE_FAILED = "Event config save failed";

    private final ModelMapper modelMapper;

    private final EventConfigRepository eventConfigRepo;

    public String createEventConfigs(List<EventConfigDto>  eventConfigDto) {
        String message = StringUtils.EMPTY;
        try {
            List<EventConfig> eventConfigs = new ArrayList<>();
            eventConfigDto.forEach(event -> {
                EventConfig eventConfig = modelMapper.map(event, EventConfig.class);
                EventConfig save = eventConfigRepo.save(eventConfig);
                eventConfigs.add(save);
            });
            message = EVENT_CONFIG_SAVE_SUCCESS;
        }catch(MongoException ex){
            message = EVENT_CONFIG_SAVE_FAILED;
            log.error("Error encountered while saving event config:{}",ex);
        }
        return message;
    }
}
