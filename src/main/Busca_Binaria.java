package main;

import java.util.Random;
import java.util.Scanner;

/**
 * 4 - Busca Binária
 * Necessário que:
 * 			- os dados estejam ordenados;
 */ 
public class Busca_Binaria {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random gerador = new Random();
		int N = 100;
		int i;

		int baseDeDados[] = new int[N];
		System.out.println("Criando vetor com 100 elementos... ");
		for (i = 0; i < N; i++) {
			baseDeDados[i] = (int) gerador.nextInt()/1000;
		}

		System.out.println("Ordenando o vetor criado...");
		boolean troca = true;
		for (i = 0; i< N-1 && troca == true; i++) {
			int aux;
			troca = false;
			for (int j = 0 ; j < N-i-1 ; j++) {
				if(baseDeDados[j] > baseDeDados[j+1]) {
					aux = baseDeDados[j];
					baseDeDados[j] = baseDeDados[j+1];
					baseDeDados[j+1] = aux;
					troca = true;
				}
			}
		}

		for (i = 0; i<N; i++) {
			System.out.println(i + "\t" + baseDeDados[i]);
		}

		System.out.println("Digite chave procurada: ");
		int chaveProcurada = sc.nextInt();

		System.out.println("Procurando a chave solicitada...");
		int i_baixo = 0;
		int i_medio = 0;
		int i_alto = N-1;
		int achou = 0;
		int posicao = -1;

		while (achou != 1 && i_baixo <= i_alto) {
			i_medio = (i_baixo + i_alto)/2;
			if(chaveProcurada == baseDeDados[i_medio]) {
				posicao = i_medio;
				achou = 1;
			} else {
				if(chaveProcurada < baseDeDados[i_medio]) {
					i_alto = i_medio - 1;
				} else {
					i_baixo = i_medio + 1;
				}
			}
		}

		if (posicao == -1) {
			System.out.println("Chave não encontrada!");
		} else {
			System.out.println("Chave encontrada na posição: " + posicao);
		}

		sc.close();
	}
}
