package com.azulay.OdontoSimple.model.repository;

import com.azulay.OdontoSimple.model.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
