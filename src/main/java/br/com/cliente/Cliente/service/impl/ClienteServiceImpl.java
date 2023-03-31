package br.com.cliente.Cliente.service.impl;

import br.com.cliente.Cliente.entities.Cliente;
import br.com.cliente.Cliente.model.request.ClienteRequest;
import br.com.cliente.Cliente.model.response.ClienteResponse;
import br.com.cliente.Cliente.repository.ClienteRepository;
import br.com.cliente.Cliente.service.ClienteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criar(ClienteRequest clienteRequest) {
        Cliente cliente = ClienteRequest.toCliente(clienteRequest);
        clienteRepository.save(cliente);
        return ClienteResponse.toClienteResponse(cliente);
    }
    @Override
    public List<ClienteResponse> pesquisarCliente() {
        return ClienteResponse.toClienteResponseList(clienteRepository.findAll());
    }
    @Transactional
    @Override
    public void delete(String email) {
        Cliente cliente = getCliente(email);
        clienteRepository.delete(cliente);
    }

    private Cliente getCliente(String email) {
        return clienteRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado"));
    }
}
