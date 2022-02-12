package com.love.lovebackend.Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class EventReceiver {

    private String receiverFirstName;

    private String receiverLastName;

    private Date receiverBirthDate;

    private Date receiverAnniversaryDate;

    private String receiverPartnerFirstName;

    private String receiverPartnerLastName;

}
