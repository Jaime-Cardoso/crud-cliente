package br.com.cliente.Cliente.controller;

import br.com.cliente.Cliente.model.request.ClienteRequest;
import br.com.cliente.Cliente.model.request.ClienteUpdateRequest;
import br.com.cliente.Cliente.model.response.ClienteResponse;
import br.com.cliente.Cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponse criar(@RequestBody ClienteRequest clienteRequest) {
        return clienteService.criar(clienteRequest);
    }

    @GetMapping
    public List<ClienteResponse> pesquisaCliente() {
        return clienteService.pesquisarCliente();
    }

    @DeleteMapping("/{email}")
    public void delete(@PathVariable String email) {
        clienteService.delete(email);
    }

    @PutMapping("/{email}")
    public void atualizar(@PathVariable String email, @RequestBody ClienteUpdateRequest clienteUpdateRequest) {
        clienteService.atualizar(email, clienteUpdateRequest);
    }
}
