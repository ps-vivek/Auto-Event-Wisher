package com.auto.eventwisher.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class EventConfigResponse {

    private String id;

    private String senderFirstName;

    private String senderPhoneNumber;

    private String receiverFirstName;

    private String receiverPhoneNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate receiverAnniversaryDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate receiverBirthDate;

}
