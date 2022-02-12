package com.love.lovebackend.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class EventReceiver {

    private String receiverFirstName;

    private String receiverLastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date receiverBirthDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date receiverAnniversaryDate;

    private String receiverPartnerFirstName;

    private String receiverPartnerLastName;

}
