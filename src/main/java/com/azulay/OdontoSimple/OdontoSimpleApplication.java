package com.azulay.OdontoSimple;

import com.azulay.OdontoSimple.model.entity.Paciente;
import com.azulay.OdontoSimple.model.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OdontoSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdontoSimpleApplication.class, args);
	}

}
