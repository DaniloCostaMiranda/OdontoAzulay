package com.azulay.OdontoSimple.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class TratamentoDTO {

    private String dente;
    @NotEmpty(message = "{campo.preco.obrigatorio}")
    private String preco;
    @NotEmpty(message = "{campo.data.obrigatorio}")
    private String data;
    @NotEmpty(message = "{campo.status.obrigatorio}")
    private String status;
    @NotNull(message = "{campo.paciente.obrigatorio}")
    private Integer idPaciente;
}
