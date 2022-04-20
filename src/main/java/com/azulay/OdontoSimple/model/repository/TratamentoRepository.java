package com.azulay.OdontoSimple.model.repository;

import com.azulay.OdontoSimple.model.entity.Tratamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TratamentoRepository extends JpaRepository<Tratamento, Integer> {

    @Query("select s from Tratamento s join s.paciente p " + " where upper(p.nome) like upper(:nome) or upper(s.status) like upper (:status) ")
    List<Tratamento> findByNomeClienteAndStatus(
            @Param("nome") String nome, @Param("status") String status);
}
