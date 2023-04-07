package br.com.cliente.Cliente.service;

import br.com.cliente.Cliente.entities.Cliente;
import br.com.cliente.Cliente.model.request.ClienteRequest;
import br.com.cliente.Cliente.model.request.ClienteUpdateRequest;
import br.com.cliente.Cliente.model.response.ClienteResponse;

import java.util.List;

public interface ClienteService {

    ClienteResponse criar(ClienteRequest clienteRequest);

    List<ClienteResponse> pesquisarCliente();

    void delete(String email);

    void atualizar(String email, ClienteUpdateRequest clienteUpdateRequest);
}
