package entities;





import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="libro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Libro extends Base{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="titulo")
	private String titulo;
	@Column(name="fecha")
	private String fecha;
	@Column(name="genero")
	private String genero;
	@Column(name="paginas")
	private int paginas;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_persona")
	private Persona persona;
	

	
	@ManyToMany(cascade = CascadeType.REFRESH)
	private List<Autor> autores = new ArrayList<Autor>();

}
