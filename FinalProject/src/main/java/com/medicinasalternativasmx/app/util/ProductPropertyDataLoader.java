package com.medicinasalternativasmx.app.util;


import java.sql.Timestamp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.medicinasalternativasmx.app.model.ProductProperty;
import com.medicinasalternativasmx.app.repository.ProductPropertyRepository;

@Component
@Profile("h2")
public class ProductPropertyDataLoader implements CommandLineRunner{
	ProductPropertyRepository productPropertyRepository;
	
	
	public ProductPropertyDataLoader(ProductPropertyRepository productPropertyRepository) {
		this.productPropertyRepository = productPropertyRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		productPropertyRepository.save(new ProductProperty(
				null,
				"Ampolleta 10 ml",
				"150 mg/ml", 
				  "Antioxidante que podría desempeñar un papel en la prevención del cáncer",
				  "Intravenoso", 
				  "Puede causar efectos secundarios como sequedad de boca, náuseas, vómitos y diarrea",
				  "México", 
				 Timestamp.valueOf("2024-06-30 23:59:59"),
				 "Conservar en un lugar fresco y seco una vez abierto"));
		
		productPropertyRepository.save(new ProductProperty(
				null,"Ampolleta 10 ml", "0.5 mg/ml", 
		  "Para fortalecer los los huesos, la reproducción, la coagulación sanguínea y para mantener un sistema inmunitario sano", "Intravenoso", 
		  "Completar el tratamiento indicado", "México", 
		  Timestamp.valueOf("2026-03-15 23:59:59"), "Proteger de la luz"));
		productPropertyRepository.save(new ProductProperty(
				null,"Frasco 25 ml", "40 mg/ml", 
		  "Ayuda a reducir el deterioro cognitivo", "Intramuscular", 
		  "No administrar a menores de 2 años", "México", 
		  Timestamp.valueOf("2025-09-30 23:59:59"), "Proteger de la luz"));
		productPropertyRepository.save(new ProductProperty(
				null,"Ampolleta 10 ml", "100 mg/ml", 
		  "Tratamiento de intoxicaciones, mejora la oxigenación del cuerpo", "Intravenoso", 
		  "Monitorizar posibles reacciones adversas", "México", 
		  Timestamp.valueOf("2027-01-15 23:59:59"), "Proteger de la luz"));
		productPropertyRepository.save(new ProductProperty(
				null,"'Frasco 30 ml", "750 mg/ml", 
		  "Ayuda a reducir el dolor e inflamación", "Oral y tópico", 
		  "No exceder la dosis recomendada", "México", 
		  Timestamp.valueOf("2025-12-31 23:59:59"), "Lugar fresco y seco"));

	}

	
}
