package br.com.cliente.Cliente.service;

import br.com.cliente.Cliente.model.request.ClienteRequest;
import br.com.cliente.Cliente.model.response.ClienteResponse;

public interface ClienteService {

    ClienteResponse criar(ClienteRequest clienteRequest);
}
