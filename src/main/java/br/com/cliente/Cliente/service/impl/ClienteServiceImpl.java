package br.com.cliente.Cliente.service.impl;

import br.com.cliente.Cliente.entities.Cliente;
import br.com.cliente.Cliente.model.request.ClienteRequest;
import br.com.cliente.Cliente.model.request.ClienteUpdateRequest;
import br.com.cliente.Cliente.model.response.ClienteResponse;
import br.com.cliente.Cliente.repository.ClienteRepository;
import br.com.cliente.Cliente.service.ClienteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Log4j2
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

    @Override
    public void atualizar(String email, ClienteUpdateRequest clienteUpdateRequest) {

        Cliente cliente = getCliente(email);
        log.info(cliente);

        if (StringUtils.hasText(clienteUpdateRequest.getTelefone())) {
            cliente.setTelefone(clienteUpdateRequest.getTelefone());
        }

        if (StringUtils.hasText(clienteUpdateRequest.getNome())) {
            cliente.setNome(clienteUpdateRequest.getNome());
        }
        clienteRepository.save(cliente);
    }

    private Cliente getCliente(String email) {
        return clienteRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado"));
    }
}
