package com.fuwa.bff_agendadorTarefas.infraestructure.client.Config;
import com.fuwa.bff_agendadorTarefas.infraestructure.exeptions.*;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {

        String MensagemErro = mensagemErro(response);

        switch (response.status()) {
            case 409:
                return new ConflictException("Erro: " + MensagemErro);
            case 403:
                return new ResorceNotFoundException("Erro: " + MensagemErro);
            case 401:
                return new UnauthorizedException("Erro: " + MensagemErro);
            case 400:
                return new IllegalArgumentsException("Erro: " + MensagemErro);
            default:
                return new BusinessException("Erro: " + MensagemErro);
        }
    }

    private String mensagemErro(Response response) {
        try {
            if (Objects.isNull(response.body())) {
                return "";
            }
            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}