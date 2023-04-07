package br.com.cliente.Cliente.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ClienteUpdateRequest {

    private String nome;

    private String telefone;


}
