package com.auto.eventwisher.graphql.query.resolver;


import com.auto.eventwisher.Entities.EventConfig;
import com.auto.eventwisher.Repositories.EventConfigRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {
    private final EventConfigRepository eventConfigRepository;

    public List<EventConfig> findAllEvents(){
        return eventConfigRepository.findAll();
    }


}
