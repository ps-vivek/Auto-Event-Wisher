package com.auto.eventwisher.graphql.mutation;

import com.auto.eventwisher.Entities.EventConfig;
import com.auto.eventwisher.Repositories.EventConfigRepository;
import com.auto.eventwisher.models.EventConfigDto;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.mongodb.MongoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class AutoEventWisherGraphQLMutationService implements GraphQLMutationResolver {

    public static final String EVENT_CONFIG_SAVE_SUCCESS = "Event config save success";
    public static final String EVENT_CONFIG_SAVE_FAILED = "Event config save failed";

    private final ModelMapper modelMapper;

    private final EventConfigRepository eventConfigRepo;

    public String createMultiEventConfig(List<EventConfigDto>  eventConfigDto) {
        String message;
        try {
            eventConfigDto.forEach(event -> eventConfigRepo.save( modelMapper.map(event, EventConfig.class)));
            message = EVENT_CONFIG_SAVE_SUCCESS;
        }catch(MongoException ex){
            message = EVENT_CONFIG_SAVE_FAILED;
            log.error("Error encountered while saving multi event config.",ex);
        }
        return message;
    }

    public String createSingleEventConfig(EventConfigDto  eventConfigDto) {
        String message;
        try {
            eventConfigRepo.save(modelMapper.map(eventConfigDto, EventConfig.class));
            message = EVENT_CONFIG_SAVE_SUCCESS;
        }catch(MongoException ex){
            message = EVENT_CONFIG_SAVE_FAILED;
            log.error("Error encountered while saving event config.",ex);
        }
        return message;
    }

    public boolean DeleteEventConfig(String  id) {
        try {
            eventConfigRepo.deleteById(id);
        }catch(MongoException ex){
            log.error("Error encountered while deleting event config.",ex);
            return false;
        }
        return true;
    }
}
