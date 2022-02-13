package com.love.lovebackend.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class EventSender {
    @NonNull
    private String senderFirstName;

    @NonNull
    private String senderLastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

    @NonNull
    private String senderPhoneNumber;

    private String uniqueSenderId;

    public void setUniqueSenderId() {
        this.uniqueSenderId = this.senderFirstName+this.senderLastName+this.senderPhoneNumber;
    }




}
