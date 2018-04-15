package com.kevatsaapas.kyselydemo;

import com.kevatsaapas.kyselydemo.controller.KysymysRepository;
import com.kevatsaapas.kyselydemo.controller.KyselyRepository;
import com.kevatsaapas.kyselydemo.model.Kysely;
import com.kevatsaapas.kyselydemo.model.Kysymys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class KyselydemoApplication {

	private static final Logger log = LoggerFactory.getLogger(KyselydemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselydemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(KysymysRepository repository, KyselyRepository krepository) {
		return args -> {
			krepository.save(new Kysely("Hyvinvointikysely"));
			repository.save(new Kysymys("Kuinka kuvaat terveydentilaasi tällä hetkellä asteikolla 1-10?"));
			repository.save(new Kysymys("Kuinka kuvaat hyvinvointiasi tällä hetkellä asteikolla 1-10?"));
			repository.save(new Kysymys("Kuinka opiskelusi sujuu?"));
		};
	}

}
