package com.commerce.desafiodev.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.desafiodev.repository.NumeroRepository;
import com.commerce.desafiodev.util.QuickSortAleatorio;

@RestController
public class DesafioController {

	@Autowired
	private NumeroRepository numeroRepository;
	private QuickSortAleatorio quickSort;

	@GetMapping(value = "/load")
	public List<Double> load() {
		List<Double> list = new ArrayList<>();
		double[] arrayAux;

		list = numeroRepository.findNumber();

		arrayAux = list.stream().mapToDouble(Double::doubleValue).toArray();

		quickSort = new QuickSortAleatorio(arrayAux, 0, arrayAux.length - 1);

		quickSort.ordenarRetorno();

		return quickSort.ordenarRetorno();

	}

}
