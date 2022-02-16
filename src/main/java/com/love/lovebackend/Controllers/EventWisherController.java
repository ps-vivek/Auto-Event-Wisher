package com.love.lovebackend.Controllers;

import com.love.lovebackend.Entities.EventConfig;
import com.love.lovebackend.models.EventConfigDto;
import com.love.lovebackend.services.EventWisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
