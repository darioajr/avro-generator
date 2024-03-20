package br.com.b3.poc.generate.avro.app;

import br.com.b3.poc.generate.avro.app.model.avro.meuregistro.AtivoOuInativo;
import br.com.b3.poc.generate.avro.app.model.avro.meuregistro.MeuRegistro;
import br.com.b3.poc.generate.avro.app.model.avro.meuregistro.Status;
import br.com.b3.poc.generate.avro.app.service.MeuRegistroService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import jakarta.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

@SpringBootApplication
@EnableWebMvc
public class AppApplication {
/*
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (String[] args) -> {
			User user1 = new User("Bob", "bob@domain.com");
			User user2 = new User("Jenny", "jenny@domain.com");
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.findAll().forEach(System.out::println);
		};
	}*/

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AppApplication.class, args);

		MeuRegistroService meuRegistroService = context.getBean(MeuRegistroService.class);

		var registro = new MeuRegistro();
		registro.setId(1);
		registro.setNome("Dario");
		registro.setCPF("11122233344");
		registro.setStatus(Status.ATIVO);

		ZonedDateTime brasilNow = ZonedDateTime.now(ZoneId.of("UTC"));
		LocalDate dataNascimento = LocalDate.of(2022, 3, 23);
		registro.setDataNascimento(dataNascimento);
		registro.setDataHoraCadastro(brasilNow.toInstant());
		meuRegistroService.adicionar(registro);

		//Registro 2
		var registro2 = new @Valid MeuRegistro();
		registro2.setId(2);
		registro2.setNome("Teste");
		registro2.setCPF("000000000");
		registro2.setIdade(200);
		registro2.setStatus(Status.INATIVO);
		registro2.setStatusnovo(AtivoOuInativo.INATIVO);
		
		registro2.setTipo(2);

		
		meuRegistroService.adicionar(registro2);


		System.out.println(meuRegistroService.listar());

		context.close();
	}

}
