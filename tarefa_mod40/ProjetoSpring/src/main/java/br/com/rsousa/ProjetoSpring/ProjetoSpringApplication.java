package br.com.rsousa.ProjetoSpring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.rsousa.domain.Cliente;
import br.com.rsousa.repository.IClienteRepository;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.rsousa.repository")
@EntityScan("br.com.rsousa.domain")
@ComponentScan(basePackages = "br.com.rsousa")

public class ProjetoSpringApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ProjetoSpringApplication.class);

	@Autowired
	private IClienteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		Cliente cliente = createCliente();
		repository.save(cliente);
	}

	private Cliente createCliente() {
		return Cliente.builder()
				.cidade("SP")
				.cpf(12312312310L)
				.email("Teste@teste.com")
				.end("End")
				.estado("SP")
				.nome("Teste Spring Boot")
				.numero(102030)
				.tel(10203040L)
				.build();
	}

}