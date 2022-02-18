package com.auto.eventwisher.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MessageService {
    @Value("${messaging.twilio.accountSid}")
    private String accountSid;

    @Value("${messaging.twilio.authToken}")
    private String authToken;

    @Value("${messaging.twilio.senderPhoneNumber}")
    private String senderPhoneNumber;

    public boolean sendMessage(String outgoingMessage, String outGoingPhoneNumber){
        Twilio.init(accountSid, authToken);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(outGoingPhoneNumber),
                        new com.twilio.type.PhoneNumber(senderPhoneNumber),
                        outgoingMessage)
                .create();

        return Objects.isNull(message)? false: true;
    }

}
