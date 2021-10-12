package com.henrry.personaslicencias.domain.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LicenseDTO {
    private String number;
    private Date expirationDate;
    private String state;
    private PersonDTO personDTO;
}
