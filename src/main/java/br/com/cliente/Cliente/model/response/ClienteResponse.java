package br.com.cliente.Cliente.model.response;

import br.com.cliente.Cliente.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteResponse {

    private String nome;
    private String email;
    private String telefone;

    public static ClienteResponse toClienteResponse(Cliente cliente) {
        if (ObjectUtils.isEmpty(cliente)){
            return null;
        }
        return ClienteResponse.builder()
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .build();
    }
    public static List<ClienteResponse> toClienteResponseList(List<Cliente> clientList) {
        return clientList.stream()
                .map(ClienteResponse::toClienteResponse)
                .collect(Collectors.toList());
    }
}
