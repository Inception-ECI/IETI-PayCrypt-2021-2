package com.inception.paycrypt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {

    private String token;

    private Date expirationDate;
}
