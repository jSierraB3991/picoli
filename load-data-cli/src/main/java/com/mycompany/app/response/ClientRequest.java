package com.mycompany.app.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ClientRequest {
    private String name;
    private String email;
    private String address;
    private String region;
    private String country;
    private String aleatoryText;
    private Integer aleatoryNumber;
}
