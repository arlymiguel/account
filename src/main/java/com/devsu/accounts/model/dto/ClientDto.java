package com.devsu.accounts.model.dto;

import lombok.*;


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {

    private Long id;
    private String password;
    private boolean state;
    private PersonDto person;

}
