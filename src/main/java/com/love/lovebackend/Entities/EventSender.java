package com.love.lovebackend.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class EventSender {
    private String senderFirstName;

    private String senderLastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date senderBirthDate;
}
