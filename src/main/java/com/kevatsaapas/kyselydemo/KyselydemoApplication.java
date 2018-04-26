package com.kevatsaapas.kyselydemo;

import com.kevatsaapas.kyselydemo.controller.KysymysRepository;
import com.kevatsaapas.kyselydemo.controller.VaihtoehtoRepository;
import com.kevatsaapas.kyselydemo.controller.KyselyRepository;
import com.kevatsaapas.kyselydemo.model.Kysely;
import com.kevatsaapas.kyselydemo.model.Kysymys;
import com.kevatsaapas.kyselydemo.model.Vaihtoehto;

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
	public CommandLineRunner demo(KysymysRepository repository, KyselyRepository krepository, VaihtoehtoRepository vrepository) {
		return  args -> {
			//testidatat paikalliseen käyttöön, ELÄ POISTA PLIISSSSS
			 
			Kysely demokysely = new Kysely("Hyvinvointikysely", "Kyselyn tarkoituksena on kartoittaa hyvinvointia", null);
			krepository.save(demokysely);
			System.out.println(demokysely.getKyselyId());
			Kysymys kys1 = new Kysymys("Onko hyvä vointi?", demokysely.getKyselyId(), "text", null, null);
			Kysymys kys2 = new Kysymys("Oletko voinut paremminkin?", demokysely.getKyselyId(), "textarea", null, null);
			Kysymys kys3 = new Kysymys("Kuinka hyvä olo on nyt?", demokysely.getKyselyId(), "radio", null, null);
			Kysymys kys4 = new Kysymys("Mitkä seuraavista asioista parantavat oloasi?", demokysely.getKyselyId(), "checkbox", null, null);
			repository.save(kys1);
			repository.save(kys2);
			repository.save(kys3);
			repository.save(kys4);
			Vaihtoehto vai1 = new Vaihtoehto("heikko", kys3.getKysymysid());
			Vaihtoehto vai2 = new Vaihtoehto("ihan ok", kys3.getKysymysid());
			Vaihtoehto vai3 = new Vaihtoehto("upee", kys3.getKysymysid());
			Vaihtoehto vai4 = new Vaihtoehto("lepo", kys4.getKysymysid());
			Vaihtoehto vai5 = new Vaihtoehto("kalja", kys4.getKysymysid());
			Vaihtoehto vai6 = new Vaihtoehto("ruoka", kys4.getKysymysid());
			Vaihtoehto vai7 = new Vaihtoehto("urheilu", kys4.getKysymysid());
			vrepository.save(vai1);
			vrepository.save(vai2);
			vrepository.save(vai3);
			vrepository.save(vai4);
			vrepository.save(vai5);
			vrepository.save(vai6);
			vrepository.save(vai7);
			
			
	
			
			


			Kysely demokysely2 = new Kysely("Pahoinvointikysely", "Tämän kyselyn tarkoituksena on kartoittaa pahoinvointia", null);
			krepository.save(demokysely2);
			Kysymys kys5 = new Kysymys("Onko paha vointi?", demokysely2.getKyselyId(), "text", null, null);
			Kysymys kys6 = new Kysymys("Oletko voinut pahemminkin?", demokysely2.getKyselyId(), "textarea", null, null);
			Kysymys kys7 = new Kysymys("Kuinka huono olo on nyt?", demokysely2.getKyselyId(), "radio", null, null);
			Kysymys kys8 = new Kysymys("Mitkä seuraavista asioista pahentavat oloasi?", demokysely2.getKyselyId(), "checkbox", null, null);
			repository.save(kys5);
			repository.save(kys6);
			repository.save(kys7);
			repository.save(kys8);
			Vaihtoehto vai8 = new Vaihtoehto("semi", kys7.getKysymysid());
			Vaihtoehto vai9 = new Vaihtoehto("huono", kys7.getKysymysid());
			Vaihtoehto vai10 = new Vaihtoehto("aika", kys7.getKysymysid());
			Vaihtoehto vai11 = new Vaihtoehto("lepo", kys8.getKysymysid());
			Vaihtoehto vai12 = new Vaihtoehto("kalja", kys8.getKysymysid());
			Vaihtoehto vai13 = new Vaihtoehto("ruoka", kys8.getKysymysid());
			Vaihtoehto vai14 = new Vaihtoehto("urheilu", kys8.getKysymysid());
			
			vrepository.save(vai8);
			vrepository.save(vai9);
			vrepository.save(vai10);
			vrepository.save(vai11);
			vrepository.save(vai12);
			vrepository.save(vai13);
			vrepository.save(vai14);
			
			
			
			
			
		};
	}

}
