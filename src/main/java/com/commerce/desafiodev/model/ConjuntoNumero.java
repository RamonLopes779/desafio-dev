package com.commerce.desafiodev.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "conjunto_numero")
@Getter
@Setter
public class ConjuntoNumero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero")
    private Double numero;

    public ConjuntoNumero(Double numero) {
        this.numero = numero;
    }
    
    public ConjuntoNumero() {
		
	}
}
