package com.fuwa.bff_agendadorTarefas.business.DTO.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TelefoneDTORequest {

    private String numero;
    private String ddd;
}
