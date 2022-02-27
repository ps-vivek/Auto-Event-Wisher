package com.auto.eventwisher.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventConfigResponse {

    private String id;

    private String senderFirstName;

    private String senderLastName;

    private String senderPhoneNumber;

    private String receiverFirstName;

    private String receiverLastName;

    private String receiverPhoneNumber;

}
