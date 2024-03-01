package eus.birt.dam.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="abestiak")
public class Abestia {
	@Id
	@SequenceGenerator(name = "col_gen_abesti", sequenceName = "col_sqe_abesti",schema="musika")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen_abesti")
	private int id;
	
	@Column
	private int ordena;
	
	@Column
	private String izenburua;
	
	@Column
	private String iraupena;
	
	@ManyToOne
	@JoinColumn (name = "diska_id")
	private Diska diska;

}
