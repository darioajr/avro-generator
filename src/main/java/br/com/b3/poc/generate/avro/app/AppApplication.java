package br.com.b3.poc.generate.avro.app;

import br.com.b3.poc.generate.avro.app.model.avro.meuregistro.MeuRegistro;
import br.com.b3.poc.generate.avro.app.model.avro.meuregistro.Status;
import br.com.b3.poc.generate.avro.app.service.MeuRegistroService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@SpringBootApplication
public class AppApplication {

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
		var registro2 = new MeuRegistro();
		registro2.setId(2);
		registro2.setNome("Teste");
		registro2.setCPF("000000000");
		registro2.setIdade(18);
		registro2.setStatus(Status.INATIVO);
		registro2.setTipo(2);
		meuRegistroService.adicionar(registro2);


		System.out.println(meuRegistroService.listar());

		context.close();
	}

}
