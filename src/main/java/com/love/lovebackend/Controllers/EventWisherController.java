package com.love.lovebackend.Controllers;

import com.love.lovebackend.models.EventConfigDto;
import com.love.lovebackend.services.EventWisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("event/config")
@RequiredArgsConstructor
public class EventWisherController {

    private final EventWisherService eventWisherService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String addEvent(@RequestBody List<EventConfigDto> eventConfigDto) {
        return eventWisherService.addEvent(eventConfigDto);
    }

}
