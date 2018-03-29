package com.kevatsaapas.kyselydemo;

import com.kevatsaapas.kyselydemo.controller.KysymysRepository;
import com.kevatsaapas.kyselydemo.model.Kysymys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KyselydemoApplication {

	private static final Logger log = LoggerFactory.getLogger(KyselydemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselydemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(KysymysRepository repository) {
		return args -> {
			repository.save(new Kysymys("Tuletko kouluun a) julkisilla, b) kävellen, c) pyörällä?"));
			repository.save(new Kysymys("Käytätkö hissiä vai rappuja?"));
			repository.save(new Kysymys("Harrastatko urheilua vapaa-ajalla?"));
		};
	}
}
