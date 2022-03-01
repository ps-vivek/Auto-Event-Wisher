package com.auto.eventwisher.Entities;

import com.bol.secure.Encrypted;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventReceiver {

    private String receiverFirstName;

    @Encrypted
    private String receiverLastName;

    @Encrypted
    private String receiverPhoneNumber;

    private WeddingAnniversaryInfoDto weddingAnniversaryInfo;

    private BirthdayInfoDto birthdayInfo;



}
