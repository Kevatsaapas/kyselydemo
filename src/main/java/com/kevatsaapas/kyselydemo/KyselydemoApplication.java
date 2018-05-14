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
			 
			/*Kysely demokysely = new Kysely("Hyvinvointikysely", "Kyselyn tarkoituksena on kartoittaa hyvinvointia", null);
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
			
			
			Kysely demokysely = new Kysely("Hyvinvointikysely", "Kyselyn tarkoituksena on kartoittaa hyvinvointia", null);
			krepository.save(demokysely);
			System.out.println(demokysely.getKyselyId());
			Kysymys kys1 = new Kysymys("Sukupuolesi? ", demokysely.getKyselyId(), "radio", null, null);
			Kysymys kys2 = new Kysymys("Ikäsi", demokysely.getKyselyId(), "radio", null, null);
			Kysymys kys3 = new Kysymys("Millä kampuksella opiskelet?", demokysely.getKyselyId(), "radio", null, null);
			Kysymys kys4 = new Kysymys("Monettako vuotta opiskelet?", demokysely.getKyselyId(), "radio", null, null);
			Kysymys kys5 = new Kysymys("Olen kokenut yksinäisyyttä opiskelujen aikana", demokysely.getKyselyId(), "radio", null, null);
			Kysymys kys6 = new Kysymys("Minun on helppo tutustua uusiin ihmisiin", demokysely.getKyselyId(), "radio", null, null);
			Kysymys kys7 = new Kysymys("Koetko, että sinulla on riittävästi opiskelukavereita?", demokysely.getKyselyId(), "radio", null, null);
			Kysymys kys8 = new Kysymys("Kuinka usein vietät aikaa opiskelukavereidesi kanssa vapaa-ajalla?", demokysely.getKyselyId(), "radio", null, null);
			Kysymys kys9 = new Kysymys("Miten vietät aikaa opiskelukavereidesi kanssa vapaa-ajalla?", demokysely.getKyselyId(), "checkbox", null, null);
			Kysymys kys10 = new Kysymys("Kerro omin sanoin", demokysely.getKyselyId(), "textarea", null, null);
			Kysymys kys11 = new Kysymys("Kuinka usein olet osallistunut opiskelijajärjestöjen tapahtumiin?", demokysely.getKyselyId(), "radio", null, null);
			Kysymys kys12 = new Kysymys("Millaisiin opiskelijajärjestön tapahtumiin olet osallistunut? ", demokysely.getKyselyId(), "checkbox", null, null);
			Kysymys kys13 = new Kysymys("Millaisia tapahtumia haluaisit, että opiskelijajärjestöt järjestävät useammin?", demokysely.getKyselyId(), "checkbox", null, null);
			Kysymys kys14 = new Kysymys("Oletko ollut tyytyväinen opiskelijajärjestöjen tapahtumiin?", demokysely.getKyselyId(), "radio", null, null);
			Kysymys kys15 = new Kysymys("Olisitko kiinnostunut muunlaisesta toiminnasta, kuin edellä mainitut?", demokysely.getKyselyId(), "textarea", null, null);
			Kysymys kys16 = new Kysymys("Mistä saat tietoa opiskelijajärjestöjen tapahtumista?  ", demokysely.getKyselyId(), "checkbox", null, null);
			Kysymys kys17 = new Kysymys("Löydätkö helposti tietoa muista tapahtumista kuin bileistä?", demokysely.getKyselyId(), "radio", null, null);
			repository.save(kys1);
			repository.save(kys2);
			repository.save(kys3);
			repository.save(kys4);
			repository.save(kys5);
			repository.save(kys6);
			repository.save(kys7);
			repository.save(kys8);
			repository.save(kys9);
			repository.save(kys10);
			repository.save(kys11);
			repository.save(kys12);
			repository.save(kys13);
			repository.save(kys14);
			repository.save(kys15);
			repository.save(kys16);
			repository.save(kys17);
			Vaihtoehto vai1 = new Vaihtoehto("Mies", kys1.getKysymysid());
			Vaihtoehto vai2 = new Vaihtoehto("Nainen", kys1.getKysymysid());
			Vaihtoehto vai3 = new Vaihtoehto("Muu", kys1.getKysymysid());
			Vaihtoehto vai4 = new Vaihtoehto("En halua vastata", kys1.getKysymysid());
			Vaihtoehto vai5 = new Vaihtoehto("18-20", kys2.getKysymysid());
			Vaihtoehto vai6 = new Vaihtoehto("21-25", kys2.getKysymysid());
			Vaihtoehto vai7 = new Vaihtoehto("26-30", kys2.getKysymysid());
			Vaihtoehto vai8 = new Vaihtoehto("30+", kys2.getKysymysid());
			Vaihtoehto vai9 = new Vaihtoehto("Pasila", kys3.getKysymysid());
			Vaihtoehto vai10 = new Vaihtoehto("Haaga", kys3.getKysymysid());
			Vaihtoehto vai11 = new Vaihtoehto("Malmi", kys3.getKysymysid());
			Vaihtoehto vai12 = new Vaihtoehto("Vierumäki", kys3.getKysymysid());
			Vaihtoehto vai13 = new Vaihtoehto("Porvoo", kys3.getKysymysid());
			Vaihtoehto vai14 = new Vaihtoehto("Ensimmäistä", kys4.getKysymysid());
			Vaihtoehto vai15 = new Vaihtoehto("Toista", kys4.getKysymysid());
			Vaihtoehto vai16 = new Vaihtoehto("Kolmatta", kys4.getKysymysid());
			Vaihtoehto vai17 = new Vaihtoehto("Neljättä", kys4.getKysymysid());
			Vaihtoehto vai18 = new Vaihtoehto("Viidettä tai enemmän", kys4.getKysymysid());
			Vaihtoehto vai19 = new Vaihtoehto("En koskaan", kys5.getKysymysid());
			Vaihtoehto vai20 = new Vaihtoehto("Harvoin", kys5.getKysymysid());
			Vaihtoehto vai21 = new Vaihtoehto("Joskus", kys5.getKysymysid());
			Vaihtoehto vai22 = new Vaihtoehto("Usein", kys5.getKysymysid());
			Vaihtoehto vai23 = new Vaihtoehto("Jatkuvasti", kys5.getKysymysid());
			Vaihtoehto vai24 = new Vaihtoehto("Kyllä", kys6.getKysymysid());
			Vaihtoehto vai25 = new Vaihtoehto("Ei", kys6.getKysymysid());
			Vaihtoehto vai26 = new Vaihtoehto("En osaa sanoa", kys6.getKysymysid());
			Vaihtoehto vai27 = new Vaihtoehto("Kyllä", kys7.getKysymysid());
			Vaihtoehto vai28 = new Vaihtoehto("Ei", kys7.getKysymysid());
			Vaihtoehto vai29 = new Vaihtoehto("En osaa sanoa", kys7.getKysymysid());
			Vaihtoehto vai30 = new Vaihtoehto("En koskaan", kys8.getKysymysid());
			Vaihtoehto vai31 = new Vaihtoehto("Joskus", kys8.getKysymysid());
			Vaihtoehto vai32 = new Vaihtoehto("Harvoin", kys8.getKysymysid());
			Vaihtoehto vai33 = new Vaihtoehto("Usein", kys8.getKysymysid());
			Vaihtoehto vai34 = new Vaihtoehto("Käydään ulkona", kys9.getKysymysid());
			Vaihtoehto vai35 = new Vaihtoehto("Pelataan videopelejä", kys9.getKysymysid());
			Vaihtoehto vai36 = new Vaihtoehto("Urheillaan", kys9.getKysymysid());
			Vaihtoehto vai37 = new Vaihtoehto("Opiskellaan", kys9.getKysymysid());
			Vaihtoehto vai38 = new Vaihtoehto("En koskaan", kys11.getKysymysid());
			Vaihtoehto vai39 = new Vaihtoehto("Kerran vuodessa", kys11.getKysymysid());
			Vaihtoehto vai40 = new Vaihtoehto("2-6kk välein", kys11.getKysymysid());
			Vaihtoehto vai41 = new Vaihtoehto("Kuukausittain", kys11.getKysymysid());
			Vaihtoehto vai42 = new Vaihtoehto("Viikottain", kys11.getKysymysid());
			Vaihtoehto vai43 = new Vaihtoehto("Bileisiin", kys12.getKysymysid());
			Vaihtoehto vai44 = new Vaihtoehto("Vuosijuhliin", kys12.getKysymysid());
			Vaihtoehto vai45 = new Vaihtoehto("Sitseihin", kys12.getKysymysid());
			Vaihtoehto vai46 = new Vaihtoehto("Spekseihin", kys12.getKysymysid());
			Vaihtoehto vai47 = new Vaihtoehto("Peli-iltoihin", kys12.getKysymysid());
			Vaihtoehto vai48 = new Vaihtoehto("Elokuvailtoihin", kys12.getKysymysid());
			Vaihtoehto vai49 = new Vaihtoehto("Kyllä", kys13.getKysymysid());
			Vaihtoehto vai50 = new Vaihtoehto("En", kys13.getKysymysid());
			Vaihtoehto vai51 = new Vaihtoehto("En osaa sanoa", kys13.getKysymysid());
			Vaihtoehto vai52 = new Vaihtoehto("Harrastekerhoja", kys14.getKysymysid());
			Vaihtoehto vai53 = new Vaihtoehto("Lukupiirejä", kys14.getKysymysid());
			Vaihtoehto vai54 = new Vaihtoehto("Peli-iltoja", kys14.getKysymysid());
			Vaihtoehto vai55 = new Vaihtoehto("Elokuvailtoja", kys14.getKysymysid());
			Vaihtoehto vai56 = new Vaihtoehto("Bileitä", kys14.getKysymysid());
			Vaihtoehto vai57 = new Vaihtoehto("En tiedä", kys16.getKysymysid());
			Vaihtoehto vai58 = new Vaihtoehto("Some", kys16.getKysymysid());
			Vaihtoehto vai59 = new Vaihtoehto("Opiskelijajärjestöjen sivuilta", kys16.getKysymysid());
			Vaihtoehto vai60 = new Vaihtoehto("Kavereilta", kys16.getKysymysid());
			Vaihtoehto vai61 = new Vaihtoehto("Tutoreilta", kys16.getKysymysid());
			Vaihtoehto vai62 = new Vaihtoehto("Muualta", kys16.getKysymysid());
			Vaihtoehto vai63 = new Vaihtoehto("Kyllä", kys17.getKysymysid());
			Vaihtoehto vai64 = new Vaihtoehto("Ei", kys17.getKysymysid());
			Vaihtoehto vai65 = new Vaihtoehto("En osaa sanoa", kys17.getKysymysid());
			vrepository.save(vai1);
			vrepository.save(vai2);
			vrepository.save(vai3);
			vrepository.save(vai4);
			vrepository.save(vai5);
			vrepository.save(vai6);
			vrepository.save(vai7);
			vrepository.save(vai8);
			vrepository.save(vai9);
			vrepository.save(vai10);
			vrepository.save(vai12);
			vrepository.save(vai13);
			vrepository.save(vai14);
			vrepository.save(vai15);
			vrepository.save(vai16);
			vrepository.save(vai17);
			vrepository.save(vai18);
			vrepository.save(vai19);
			vrepository.save(vai20);
			vrepository.save(vai21);
			vrepository.save(vai22);
			vrepository.save(vai23);
			vrepository.save(vai24);
			vrepository.save(vai25);
			vrepository.save(vai26);
			vrepository.save(vai27);
			vrepository.save(vai28);
			vrepository.save(vai29);
			vrepository.save(vai30);
			vrepository.save(vai31);
			vrepository.save(vai32);
			vrepository.save(vai33);
			vrepository.save(vai34);
			vrepository.save(vai35);
			vrepository.save(vai36);
			vrepository.save(vai37);
			vrepository.save(vai38);
			vrepository.save(vai39);
			vrepository.save(vai40);
			vrepository.save(vai41);
			vrepository.save(vai42);
			vrepository.save(vai43);
			vrepository.save(vai44);
			vrepository.save(vai45);
			vrepository.save(vai46);
			vrepository.save(vai47);
			vrepository.save(vai48);
			vrepository.save(vai49);
			vrepository.save(vai50);
			vrepository.save(vai51);
			vrepository.save(vai52);
			vrepository.save(vai53);
			vrepository.save(vai54);
			vrepository.save(vai55);
			vrepository.save(vai56);
			vrepository.save(vai57);
			vrepository.save(vai58);
			vrepository.save(vai59);
			vrepository.save(vai60);
			vrepository.save(vai61);
			vrepository.save(vai62);
			vrepository.save(vai63);
			vrepository.save(vai64);
			vrepository.save(vai65);
	
			
			


			Kysely demokysely2 = new Kysely("Kuntokysely", "Tämän kyselyn tarkoituksena on kartoittaa kuntoa", null);
			krepository.save(demokysely2);
			Kysymys kys18 = new Kysymys("Kuinka pitkä koulumatkasi on?", demokysely2.getKyselyId(), "text", null, null);
			Kysymys kys19 = new Kysymys("Millä kulkuneuvolla tulet kouluun?", demokysely2.getKyselyId(), "text", null, null);
			Kysymys kys20 = new Kysymys("Käytätkö portaita vai hissiä koulussa?", demokysely2.getKyselyId(), "radio", null, null);
			Kysymys kys21 = new Kysymys("Kuinka paljon kuntoilet viikossa?", demokysely2.getKyselyId(), "radio", null, null);
			Kysymys kys22 = new Kysymys("Käytätkö koulun kuntosalia?", demokysely2.getKyselyId(), "radio", null, null);
			Kysymys kys23 = new Kysymys("Voisiko koulun kuntosalia parantaa jotenkin?", demokysely2.getKyselyId(), "textarea", null, null);
			repository.save(kys18);
			repository.save(kys19);
			repository.save(kys20);
			repository.save(kys21);
			repository.save(kys22);
			repository.save(kys23);
			Vaihtoehto vai66 = new Vaihtoehto("Portaat", kys20.getKysymysid());
			Vaihtoehto vai67 = new Vaihtoehto("Hissi", kys20.getKysymysid());
			Vaihtoehto vai68 = new Vaihtoehto("0", kys21.getKysymysid());
			Vaihtoehto vai69 = new Vaihtoehto("1h", kys21.getKysymysid());
			Vaihtoehto vai70 = new Vaihtoehto("2-5h", kys21.getKysymysid());
			Vaihtoehto vai71 = new Vaihtoehto("6+", kys21.getKysymysid());
			Vaihtoehto vai72 = new Vaihtoehto("Kyllä", kys22.getKysymysid());
			Vaihtoehto vai73 = new Vaihtoehto("En", kys22.getKysymysid());
		
			
			vrepository.save(vai66);
			vrepository.save(vai67);
			vrepository.save(vai68);
			vrepository.save(vai69);
			vrepository.save(vai70);
			vrepository.save(vai71);
			vrepository.save(vai72);
			vrepository.save(vai73);*/
			
		};
	}

}
