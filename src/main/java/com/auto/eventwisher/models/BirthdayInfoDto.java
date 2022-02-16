package com.auto.eventwisher.models;

import com.bol.secure.Encrypted;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class BirthdayInfoDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Encrypted
    private Date receiverBirthDate;

    @Encrypted
    private String customBirthdayWish;

}
