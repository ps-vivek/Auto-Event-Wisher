package com.love.lovebackend.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Setter
@Getter
public class EventConfig {

    @Id
    private String id;

    private EventSender eventSenderConfig;

    private EventReceiver eventReceiverConfig;

}
