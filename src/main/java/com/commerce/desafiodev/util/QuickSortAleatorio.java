package com.commerce.desafiodev.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * Algoritmo de ordenação QuickSort com pivô aleatório com partição de Cormen
 * 
 * A estratégia do algoritmo consiste em particionar os elementos e reorganizar os elementos de forma
 * que os elementos menores ou iguais ao pivô (elemento chave para particionamento) fiquem a esquerda
 * e os elementos maiores fiquem a direita; 
 */
public class QuickSortAleatorio {

	private BigDecimal[] arrayBig;
	private int inicio;
	private int fim;
	List<BigDecimal> arrayAux;

	public QuickSortAleatorio(BigDecimal[] array, int inicio, int fim) {
		this.arrayBig = array;
		this.inicio = inicio;
		this.fim = fim;
	}

	public List<BigDecimal> ordenarRetorno() {

		quickSortAleatorio(arrayBig, inicio, fim);

		List<BigDecimal> arrayAux = Arrays.asList(arrayBig);

		return arrayAux;

	}

	private static int particao(BigDecimal[] arrayBig, int inicio, int fim) {

		// Escolhe o índece aleatoriamente
		Random numeroRandom = new Random();
		int indexRandom;
		BigDecimal pivo;
		int i;

		indexRandom = numeroRandom.nextInt(fim - inicio + 1) + inicio;

		troca(arrayBig, indexRandom, fim);

		pivo = arrayBig[fim];
		i = inicio - 1;

		// Os elementos menores ou iguais ao pivô são colocados na partição a esquerda
		for (int j = inicio; j <= fim - 1; j++) {
			if (arrayBig[j].compareTo(pivo) <= 0) {
				i = i + 1;
				troca(arrayBig, i, j);
			}
		}

		troca(arrayBig, i + 1, fim);
		return i + 1;

	}

	// Realiza as trocas do elementos
	private static void troca(BigDecimal[] arrayBig, int inicio, int fim) {
		BigDecimal aux = arrayBig[inicio];
		arrayBig[inicio] = arrayBig[fim];
		arrayBig[fim] = aux;
	}

	// Executa a partição e a ordenação dos elementos
	public static void quickSortAleatorio(BigDecimal[] arrayBig, int inicio, int fim) {
		int aux;

		if (inicio < fim) {

			// Realiza a partição
			aux = particao(arrayBig, inicio, fim);

			// Ordena a partição a esquerda
			quickSortAleatorio(arrayBig, inicio, aux - 1);
			// Ordena a partição a direita
			quickSortAleatorio(arrayBig, aux + 1, fim);
		}

	}

}
