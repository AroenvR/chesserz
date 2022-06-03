package com.breaker.chesserz.dto;

import lombok.Data;

@Data
public class MoveDTO {

    private String color;
    private String flags;
    private String from;
    private String piece;
    private String san;
    private String to;

}
