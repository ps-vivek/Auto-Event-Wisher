package com.auto.eventwisher.Controllers;

import com.auto.eventwisher.Entities.EventConfig;
import com.auto.eventwisher.models.EventConfigDto;
import com.auto.eventwisher.services.EventWisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/event/config")
@RequiredArgsConstructor
public class EventWisherController {

    private final EventWisherService eventWisherService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<EventConfig> addEvent(@RequestBody List<EventConfigDto> eventConfigDto) {
        return eventWisherService.addEvent(eventConfigDto);
    }

}