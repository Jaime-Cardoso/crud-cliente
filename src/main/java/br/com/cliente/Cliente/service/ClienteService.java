package br.com.cliente.Cliente.service;

import br.com.cliente.Cliente.model.request.ClienteRequest;
import br.com.cliente.Cliente.model.response.ClienteResponse;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    public ClienteResponse criar(ClienteRequest clienteRequest) {

        //TODO - CONVERTER PARA ENTIDADE
        //TODO - GRAVAR NA BASE DE DADOS

        ClienteResponse clienteResponse = ClienteResponse.builder()
                .nome(clienteRequest.getNome())
                .telefone(clienteRequest.getTelefone())
                .build();

        return clienteResponse;

    }
}
