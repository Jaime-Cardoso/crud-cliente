package br.com.cliente.Cliente.model.request;

import br.com.cliente.Cliente.entities.Cliente;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteRequest {

    private String nome;

    @Email
    private String email;

    @CPF
    private String cpf;

    private String telefone;

    public static Cliente toCliente(ClienteRequest clienteRequest) {
        return Cliente.builder()
                .nome(clienteRequest.getNome())
                .email(clienteRequest.getEmail())
                .cpf(clienteRequest.getCpf())
                .telefone(clienteRequest.getTelefone())
                .build();

    }

}
