package com.love.lovebackend.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Setter
@Getter
public class Log {
    @Id
    private String id;
    private String message;

}
