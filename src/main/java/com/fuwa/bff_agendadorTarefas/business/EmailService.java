package com.fuwa.bff_agendadorTarefas.business;


import com.fuwa.bff_agendadorTarefas.business.DTO.out.TarefasDTOResponse;
import com.fuwa.bff_agendadorTarefas.infraestructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class EmailService {
    private final EmailClient emailClient;


    public void enviaEmail(TarefasDTOResponse dto) {
        emailClient.enviarEmail(dto);
    }
}