package com.love.lovebackend.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.love.lovebackend.models.BirthdayInfoDto;
import com.love.lovebackend.models.WeddingAnniversaryInfoDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class EventReceiver {

    private String receiverFirstName;

    private String receiverLastName;

    private String receiverPhoneNumber;

    private WeddingAnniversaryInfoDto weddingAnniversaryInfo;

    private BirthdayInfoDto birthdayInfo;

    private String uniqueReceiverId;

    public void setUniqueReceiverId() {
        this.uniqueReceiverId = this.receiverFirstName+this.receiverLastName+this.receiverPhoneNumber;
    }

}
