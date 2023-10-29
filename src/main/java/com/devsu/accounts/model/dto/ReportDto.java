package com.devsu.accounts.model.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportDto {

    private Date movementDate;
    private String client;
    private String accountNumber;
    private String accountType;
    private Double balance;
    private Boolean state;
    private Double movementValue;

}
