package com.love.lovebackend.Entities;

import com.bol.secure.Encrypted;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document("eventConfig")
public class EventConfig {

    @Id
    private String id;

    private EventSender eventSenderConfig;

    private EventReceiver eventReceiverConfig;

}
