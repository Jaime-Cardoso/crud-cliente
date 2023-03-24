package br.com.cliente.Cliente.service.impl;

import br.com.cliente.Cliente.entities.Cliente;
import br.com.cliente.Cliente.model.request.ClienteRequest;
import br.com.cliente.Cliente.model.response.ClienteResponse;
import br.com.cliente.Cliente.repository.ClienteRepository;
import br.com.cliente.Cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criar(ClienteRequest clienteRequest) {

        Cliente cliente = new Cliente();
        cliente.setNome(clienteRequest.getNome());
        cliente.setCpf(clienteRequest.getCpf());
        cliente.setTelefone(clienteRequest.getTelefone());

        clienteRepository.save(cliente);

        ClienteResponse clienteResponse = ClienteResponse.builder()
                .nome(cliente.getNome())
                .telefone(cliente.getTelefone())
                .build();

        return clienteResponse;

    }
}
