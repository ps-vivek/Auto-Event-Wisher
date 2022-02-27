package com.auto.eventwisher.Entities;

import com.bol.secure.Encrypted;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
public class BirthdayInfoDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Encrypted
    private LocalDate receiverBirthDate;

    @Encrypted
    private String customBirthdayWish;

}
