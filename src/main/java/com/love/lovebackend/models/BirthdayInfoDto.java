package com.love.lovebackend.models;

import com.bol.secure.Encrypted;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class BirthdayInfoDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date receiverBirthDate;

    @Encrypted
    private String customBirthdayWish;

}
