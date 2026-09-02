package com.fuwa.bff_agendadorTarefas.business;

import com.fuwa.bff_agendadorTarefas.business.DTO.in.LoginRequestDTO;
import com.fuwa.bff_agendadorTarefas.business.DTO.out.TarefasDTOResponse;
import com.fuwa.bff_agendadorTarefas.business.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CronsService {

    private final TarefaService tarefaService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;
    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefasDProximaHora(){
        String token = Login(converterParaRequestDTO());
        log.info("Iniciada a busca de tarefas");
        LocalDateTime Horaatual =  LocalDateTime.now();
        LocalDateTime horaFutura = LocalDateTime.now().plusHours(1);
        List<TarefasDTOResponse> ListaTarefas = tarefaService.buscaTarefasAgendadasPorPeriodo(Horaatual, horaFutura, token);
        log.info("Tarefas encontradas" + ListaTarefas);

        ListaTarefas.forEach(tarefa -> {emailService.enviaEmail(tarefa);
            log.info("Email enviado para o usuario" + tarefa.getEmailusuario());
        tarefaService.alretaStatus(StatusNotificacaoEnum.NOTIFICADO, tarefa.getId(), token);
        });
        log.info("Finalizada a busca e notificação de tarefas");
    }

    public String Login(LoginRequestDTO dto){
        return usuarioService.loginUsuario(dto);
    }

    public LoginRequestDTO converterParaRequestDTO(){
        return LoginRequestDTO.builder()
                .email(email)
                .senha(senha)
                .build();
    }
}
