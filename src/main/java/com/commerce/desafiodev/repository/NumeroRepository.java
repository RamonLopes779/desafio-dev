package com.commerce.desafiodev.repository;

import com.commerce.desafiodev.model.ConjuntoNumero;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NumeroRepository extends JpaRepository<ConjuntoNumero, Integer> {
	
	@Query(value = "SELECT NUMERO FROM CONJUNTO_NUMERO", nativeQuery = true)
	public List<BigDecimal> findNumber();
}