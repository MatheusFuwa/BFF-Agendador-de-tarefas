package com.fuwa.bff_agendadorTarefas.infraestructure.exeptions;

public class IllegalArgumentsException extends RuntimeException {
    public IllegalArgumentsException(String mensagem) {
        super(mensagem);
    }
    public IllegalArgumentsException(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }
}
