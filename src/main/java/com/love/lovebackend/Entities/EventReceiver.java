package com.love.lovebackend.Entities;

import com.bol.secure.Encrypted;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.love.lovebackend.models.BirthdayInfoDto;
import com.love.lovebackend.models.WeddingAnniversaryInfoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventReceiver {

    private String receiverFirstName;

    private String receiverLastName;

    @Encrypted
    private String receiverPhoneNumber;

    private WeddingAnniversaryInfoDto weddingAnniversaryInfo;

    private BirthdayInfoDto birthdayInfo;



}
