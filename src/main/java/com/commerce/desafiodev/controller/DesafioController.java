package com.commerce.desafiodev.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.desafiodev.repository.NumeroRepository;
import com.commerce.desafiodev.util.QuickSortAleatorio;

@RestController
public class DesafioController {

	@Autowired
	private NumeroRepository numeroRepository;
	private QuickSortAleatorio quickSort;

	@GetMapping(value = "/load")
	public List<BigDecimal> load() {
		List<BigDecimal> list = new ArrayList<>();
		BigDecimal[] arrayAux;

		list = numeroRepository.findNumber();
		
		arrayAux = list.toArray(new BigDecimal[0]);
		
		quickSort = new QuickSortAleatorio(arrayAux, 0, arrayAux.length - 1);

		quickSort.ordenarRetorno();

		return quickSort.ordenarRetorno();

	}

}
