package com.fuwa.bff_agendadorTarefas.infraestructure.client;

import com.fuwa.bff_agendadorTarefas.business.DTO.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Notificacao", url = "${notificacao.url}")
public interface EmailClient {

    void enviarEmail(@RequestBody TarefasDTOResponse dto);

}
