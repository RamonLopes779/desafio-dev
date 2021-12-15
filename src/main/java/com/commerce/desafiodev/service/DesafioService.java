package com.commerce.desafiodev.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.commerce.desafiodev.client.DesafioClient;
import com.commerce.desafiodev.model.Numero;
import com.commerce.desafiodev.model.ConjuntoNumero;
import com.commerce.desafiodev.repository.NumeroRepository;
import org.springframework.stereotype.Service;

@Service
public class DesafioService {

	@Autowired
	DesafioClient desafioClient;
	ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private NumeroRepository numeroRepository;

	public void initialLoad() throws JsonProcessingException {

		int i = 1;
		while (i <= 2) {
			try {
				String json = desafioClient.getNumbers(i);

				Numero n = objectMapper.readValue(json, Numero.class);

				/*if (n.getNumbers().length <= 0) {
					break;
				}*/

				for (int j = 0; j < n.getNumbers().length; j++) {
					Double[] array = n.getNumbers();
					ConjuntoNumero conjuntoNumero = new ConjuntoNumero(array[j]);
					
					numeroRepository.save(conjuntoNumero);
				}
				System.out.println("SUCCESS ==> " + i);
				i++;
			} catch (Exception e) {
				System.err.println("ERROR page ==> " + i);
			}

		}

	}
}
