package com.auto.eventwisher.models;

import com.auto.eventwisher.Entities.EventReceiver;
import com.auto.eventwisher.Entities.EventSender;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventConfigDto {

    private String id;

    private EventSender eventSenderConfig;

    private EventReceiver eventReceiverConfig;

}
