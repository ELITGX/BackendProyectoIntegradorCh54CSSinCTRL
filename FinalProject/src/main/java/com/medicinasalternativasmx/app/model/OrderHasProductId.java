package com.medicinasalternativasmx.app.model;


//Clase que representa la clave primaria compuesta de la entidad OrderHasProduct
//Necesaria cuando se usan múltiples campos como @Id en una entidad con @IdClass
import java.io.Serializable; // Requerido por JPA para claves compuestas
import java.util.Objects;  

public class OrderHasProductId implements Serializable {

	// Requerido para clases serializables
	private static final long serialVersionUID = 1L;
	private Long order;
	private Long product;
	
	public OrderHasProductId() {}
	
	public OrderHasProductId(Long order, Long product) {
	    this.order = order;
	    this.product = product;
	}
	
	// Sobrescribe el método equals para comparar claves compuestas de forma lógica
	@Override
	public boolean equals(Object o) {
	    // Si es el mismo objeto, son iguales
	    if (this == o) return true;

	    // Si el otro objeto no es del mismo tipo, no son iguales
	    if (!(o instanceof OrderHasProductId)) return false;
	
	    // Compara ambos campos (order y product) para determinar si son iguales
	    OrderHasProductId that = (OrderHasProductId) o;
	    return Objects.equals(order, that.order) &&
	           Objects.equals(product, that.product);
	}
	
	// Sobrescribe el método hashCode, usado en estructuras como HashSet o HashMap
	// Asegura que dos claves iguales generen el mismo código hash
	@Override
	public int hashCode() {
	    return Objects.hash(order, product);
	}
}
