package br.com.cliente.Cliente.controller;

import br.com.cliente.Cliente.model.request.ClienteRequest;
import br.com.cliente.Cliente.model.response.ClienteResponse;
import br.com.cliente.Cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClientController {

    private final ClienteService clienteService;


    @PostMapping
    public ClienteResponse criar(@RequestBody ClienteRequest clienteRequest) {

        ClienteResponse clienteResponse = clienteService.criar(clienteRequest);

        return clienteResponse;
    }
}
