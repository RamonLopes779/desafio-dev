package com.commerce.desafiodev.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/*
 * Algoritmo de ordenação QuickSort com pivô aleatório com partição de Cormen
 * 
 * A estratégia do algoritmo consiste em particionar os elementos e reorganizar os elementos de forma
 * que os elementos menores ou iguais ao pivô (elemento chave para particionamento) fiquem a esquerda
 * e os elementos maiores fiquem a direita; 
 */
public class QuickSortAleatorio {

	private double[] array;
	//private BigDecimal[] arrayBig;
	private int inicio;
	private int fim;

	public QuickSortAleatorio(double[] array, int inicio, int fim) {
		this.array = array;
		this.inicio = inicio;
		this.fim = fim;
	}

	public List<Double> ordenarRetorno() {

		quickSortAleatorio(array, inicio, fim);

		List<Double> arrayAux = DoubleStream.of(array).boxed().collect(Collectors.toList());

		return arrayAux;

	}

	private static int particao(double[] array, int inicio, int fim) {

		// Escolhe o índece aleatoriamente
		Random numeroRandom = new Random();
		int indexRandom;
		Double pivo;
		int i;

		indexRandom = numeroRandom.nextInt(fim - inicio + 1) + inicio;

		troca(array, indexRandom, fim);

		pivo = array[fim];
		i = inicio - 1;

		// Os elementos menores ou iguais ao pivô são colocados na partição a esquerda
		for (int j = inicio; j <= fim - 1; j++) {
			if (array[j] <= pivo) {
				i = i + 1;
				troca(array, i, j);
			}
		}

		troca(array, i + 1, fim);
		return i + 1;

	}

	// Realiza as trocas do elementos
	private static void troca(double[] array, int inicio, int fim) {
		Double aux = array[inicio];
		array[inicio] = array[fim];
		array[fim] = aux;
	}

	// Executa a partição e a ordenação dos elementos
	public static void quickSortAleatorio(double[] array, int inicio, int fim) {
		int aux;

		if (inicio < fim) {

			// Realiza a partição
			aux = particao(array, inicio, fim);

			// Ordena a partição a esquerda
			quickSortAleatorio(array, inicio, aux - 1);
			// Ordena a partição a direita
			quickSortAleatorio(array, aux + 1, fim);
		}

	}

	/* Teste
	 * public static List<BigDecimal> toBigDecimalList(double... list) {
	 * List<BigDecimal> result = new ArrayList<BigDecimal>(list.length); for (int i
	 * = 0; i < list.length; i++) { result.add(BigDecimal.valueOf(list[i])); }
	 * return result; }
	 */
}
