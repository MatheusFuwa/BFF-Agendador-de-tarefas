package com.fuwa.bff_agendadorTarefas.business;


import com.fuwa.bff_agendadorTarefas.business.DTO.in.TarefasDTORequest;
import com.fuwa.bff_agendadorTarefas.business.DTO.out.TarefasDTOResponse;
import com.fuwa.bff_agendadorTarefas.business.enums.StatusNotificacaoEnum;
import com.fuwa.bff_agendadorTarefas.infraestructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TarefaService {
    private final TarefasClient tarefasClient;


    public TarefasDTOResponse GravarTarefa(String token, TarefasDTORequest dto) {
        return tarefasClient.gravarTarefas(dto, token);
    }

    public List<TarefasDTOResponse> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal, String token) {
        return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> BuscaTarefasPorEmail(String token) {
        return tarefasClient.buscaTarefaPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {
        tarefasClient.deletaTarefaPorId(id, token);
    }

    public TarefasDTOResponse alretaStatus(StatusNotificacaoEnum status, String id, String token) {
        return tarefasClient.alteraStatusNotificacao(status, id, token);

    }

    public TarefasDTOResponse uptadeTarefas(TarefasDTORequest dto, String id, String token) {
        return tarefasClient.uptadeTarefas(dto, id, token);
    }
}