package com.fuwa.bff_agendadorTarefas.business;

import com.fuwa.bff_agendadorTarefas.business.DTO.in.EnderecoDTORequest;
import com.fuwa.bff_agendadorTarefas.business.DTO.in.LoginRequestDTO;
import com.fuwa.bff_agendadorTarefas.business.DTO.in.TelefoneDTORequest;
import com.fuwa.bff_agendadorTarefas.business.DTO.in.UsuarioDTORequest;
import com.fuwa.bff_agendadorTarefas.business.DTO.out.EnderecoDTOResponse;
import com.fuwa.bff_agendadorTarefas.business.DTO.out.TelefoneDTOResponse;
import com.fuwa.bff_agendadorTarefas.business.DTO.out.UsuarioDTOResponse;
import com.fuwa.bff_agendadorTarefas.infraestructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioClient client;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTOResponse usuarioDTO){
        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO usuarioDTO){
        return client.login(usuarioDTO);
    }
    public UsuarioDTOResponse buscarUsuaroPorEmail(String email, String token){
        return client.buscaUsuarioPorEmail(email, token);
    }
    public void deletaUsuarioPorEmail(String email, String token){
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto){
        return client.atualizaDadosUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token){
        return client.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token){
        return client.atualizaTelefone(dto, idTelefone, token);
    }
    public EnderecoDTOResponse CadastraEndereco(String token, EnderecoDTORequest dto){
        return client.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse CadastraTelefone(String token, TelefoneDTORequest dto){
        return client.cadastraTelefone(dto, token);
    }
}