package com.love.lovebackend.models;

import com.love.lovebackend.Entities.EventReceiver;
import com.love.lovebackend.Entities.EventSender;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class EventConfigDto {

    private String id;

    private EventSender eventSenderConfig;

    private EventReceiver eventReceiverConfig;

}
