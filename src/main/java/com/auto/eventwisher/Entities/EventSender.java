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
public class EventSender {

    private String senderFirstName;

    @Encrypted
    private String senderLastName;

    @Encrypted
    private String senderPhoneNumber;


}
