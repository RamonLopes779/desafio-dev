package com.commerce.desafiodev.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

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
    @Column(name = "numero", precision = 25, scale = 20)
    private BigDecimal numero;

    public ConjuntoNumero(BigDecimal numero) {
        this.numero = numero;
    }
    
    public ConjuntoNumero() {
		
	}
}
