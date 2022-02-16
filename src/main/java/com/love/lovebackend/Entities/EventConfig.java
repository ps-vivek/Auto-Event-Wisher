package com.love.lovebackend.Entities;

import com.bol.secure.Encrypted;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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

    @Encrypted
    private String uniqueSenderId;

    @Encrypted
    private String uniqueReceiverId;

    public void setUniqueReceiverId() {
        this.uniqueReceiverId = eventReceiverConfig.getReceiverFirstName()+
                                eventReceiverConfig.getReceiverLastName()+
                                eventReceiverConfig.getReceiverPhoneNumber();
    }
    public void setUniqueSenderId() {
        this.uniqueSenderId = eventSenderConfig.getSenderFirstName()
                                +eventSenderConfig.getSenderLastName()
                                +eventSenderConfig.getSenderPhoneNumber();
    }


}
