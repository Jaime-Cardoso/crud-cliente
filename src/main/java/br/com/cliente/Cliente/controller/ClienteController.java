package br.com.cliente.Cliente.controller;

import br.com.cliente.Cliente.model.request.ClienteRequest;
import br.com.cliente.Cliente.model.response.ClienteResponse;
import br.com.cliente.Cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public void delete(@PathVariable String email){
        clienteService.delete(email);
    }

}
