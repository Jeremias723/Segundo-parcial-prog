package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="localidad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited



public class Localidad extends Base{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="denominacion")
	private String denominacion;
	@OneToMany(mappedBy="localidad",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Domicilio> listadoDomicilios = new ArrayList<Domicilio>();


}
