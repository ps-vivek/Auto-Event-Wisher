package com.love.lovebackend.Entities;

import com.bol.secure.Encrypted;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventSender {

    private String senderFirstName;

    @Encrypted
    private String senderLastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

    @Encrypted
    private String senderPhoneNumber;





}
