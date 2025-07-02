package com.medicinasalternativasmx.app.model;


import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Table(name="products_properties")
@Entity
public class ProductProperty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="presentation", length=50, nullable=false)
	private String presentation;
	
	@Column(name="concentration", length=100, nullable=false)
	private String concentration;
	
	@Column(name="description", length=255, nullable=false)
	private String description;
	
	@Column(name="administration", length=255, nullable=false)
	private String administration;
	
	@Column(name="precautions", length=255, nullable=false)
	private String precautions;
	
	@Column(name="origin", length=50, nullable=true)
	private String origin;
	
	@Column(name="expiration_date", nullable=false)
	private Timestamp expirationDate;
	
	@Column(name="storage", nullable=true)
	private String storage;
	
	// Relación con entidad Product
	@OneToMany(mappedBy= "productProperty", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Product> product = new HashSet<>();
	

	public ProductProperty() {
	}

	public ProductProperty(Long id, String presentation, String concentration, String description,
			String administration, String precautions, String origin, Timestamp expirationDate, String storage) {
		super();
		this.id = id;
		this.presentation = presentation;
		this.concentration = concentration;
		this.description = description;
		this.administration = administration;
		this.precautions = precautions;
		this.origin = origin;
		this.expirationDate = expirationDate;
		this.storage = storage;
	}
	
	// Get necesario para solicitar los datos de la tabla one to many de product
	public Set<Product> getProducts() {
		return product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getConcentration() {
		return concentration;
	}

	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdministration() {
		return administration;
	}

	public void setAdministration(String administration) {
		this.administration = administration;
	}

	public String getPrecautions() {
		return precautions;
	}

	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Timestamp getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductProperty [id=");
		builder.append(id);
		builder.append(", presentation=");
		builder.append(presentation);
		builder.append(", concentration=");
		builder.append(concentration);
		builder.append(", description=");
		builder.append(description);
		builder.append(", administration=");
		builder.append(administration);
		builder.append(", precautions=");
		builder.append(precautions);
		builder.append(", origin=");
		builder.append(origin);
		builder.append(", expirationDate=");
		builder.append(expirationDate);
		builder.append(", storage=");
		builder.append(storage);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
