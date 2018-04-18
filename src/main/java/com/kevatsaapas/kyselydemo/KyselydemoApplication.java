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
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class KyselydemoApplication {

	private static final Logger log = LoggerFactory.getLogger(KyselydemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselydemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(KysymysRepository repository, KyselyRepository krepository) {
		return  args -> {
			
			/*Kysely demokysely = new Kysely("Hyvinvointikysely");


            krepository.save(demokysely);
			repository.save(new Kysymys("Kuinka kuvaat terveydentilaasi tällä hetkellä asteikolla 1-10?", demokysely.getKyselyId()));
			repository.save(new Kysymys("Kuinka kuvaat hyvinvointiasi tällä hetkellä asteikolla 1-10?", demokysely.getKyselyId()));
			repository.save(new Kysymys("Kuinka opiskelusi sujuu?", demokysely.getKyselyId()));
			


			Kysely demokysely2 = new Kysely("Pahoinvointikysely");

			krepository.save(demokysely2);
			repository.save(new Kysymys("Kuinka kuvaat terveydentilaasi tällä hetkellä asteikolla 1-10?", demokysely2.getKyselyId()));
			repository.save(new Kysymys("Kuinka kuvaat hyvinvointiasi tällä hetkellä asteikolla 1-10?", demokysely2.getKyselyId()));
			repository.save(new Kysymys("Kuinka opiskelusi sujuu?", demokysely2.getKyselyId()));*/
			
			
		};
	}

}
