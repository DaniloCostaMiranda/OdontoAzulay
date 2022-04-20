package com.azulay.OdontoSimple.rest;

import com.azulay.OdontoSimple.model.entity.Paciente;
import com.azulay.OdontoSimple.model.entity.Tratamento;
import com.azulay.OdontoSimple.model.repository.PacienteRepository;
import com.azulay.OdontoSimple.model.repository.TratamentoRepository;
import com.azulay.OdontoSimple.rest.dto.TratamentoDTO;
import com.azulay.OdontoSimple.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/tratamentos")
@RequiredArgsConstructor
public class TratamentoController {

    private final PacienteRepository pacienteRepository;
    private final TratamentoRepository tratamentoRepository;
    private final BigDecimalConverter bigDecimalConverter;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tratamento salvar(@RequestBody @Valid TratamentoDTO dto){

        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idPaciente = dto.getIdPaciente();

        Paciente paciente =
                pacienteRepository
                        .findById(idPaciente)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Paciente inexistente"));
        Tratamento tratamento = new Tratamento();
        tratamento.setDente(dto.getDente());
        tratamento.setData(data);
        tratamento.setPaciente(paciente);
        tratamento.setStatus(dto.getStatus());
        tratamento.setValor(bigDecimalConverter.converter(dto.getPreco()));

        return tratamentoRepository.save(tratamento);

    }

    @GetMapping
    public List<Tratamento> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "status", required = false, defaultValue = "") String status
    ){
        return tratamentoRepository.findByNomeClienteAndStatus("%" + nome + "%", "%" + status + "%");
    }

}
