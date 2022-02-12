package com.love.lovebackend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class WeddingAnniversaryInfoDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date receiverAnniversaryDate;

    private String customAnniversaryWish;

    private String receiverPartnerFirstName;

    private String receiverPartnerLastName;
}
