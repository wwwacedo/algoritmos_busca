package main;

import java.util.Random;
import java.util.Scanner;

/** 
 * 3 - Busca Sequencial Indexada
 * Necessário que:
* 			- os dados estejam ordenados;
 * 			- exista tabela de índice.
 */ 
public class Busca_Sequencial_Indexada {
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

		// Busca sequencial indexada
		// gera tabela de índice especificando o tamanho do sub-conjunto
		int n, j;
		System.out.println("Digite o tamanho de cada subconjunto: ");
		int Tamanho_Subconjunto = sc.nextInt();

		j = Tamanho_Subconjunto;
		n = N/Tamanho_Subconjunto;

		// tabela de índice == 2 vetores
		int k_indice[] = new int[N];
		int p_indice[] = new int[N];

		for (i = 0; i < n; i++) {
			k_indice[i] = baseDeDados[j-1];
			p_indice[i] = j-1;
			j += Tamanho_Subconjunto;
		}

		System.out.println("\tTabela de Índices: ");
		System.out.println("\tp\tk");
		for (i = 0; i < n; i++) {
			System.out.println("\t" + p_indice[i] + "\t" + k_indice[i]);
		}

		System.out.println("Digite chave procurada: ");
		int chaveProcurada = sc.nextInt();

		int low, hi;
		for(i=0 ; i<n && k_indice[i] < chaveProcurada ; i++);
		if (k_indice[i] != chaveProcurada) {
			if (i == 0) {
				low = 0;
			} else {
				low = p_indice[i-1];
			}
			if (i == n) {
				hi = N-1;
			} else {
				hi = p_indice[i];
			}

			for (j=low; j<hi && baseDeDados[j] != chaveProcurada; j++);
		
			if (j < hi) {
				System.out.println("Chave encontrada na posição: " + j);
			} else {
				System.out.println("Chave não encontrada!");
			}

		} else {
			System.out.println("Chave encontrada na posição: " + p_indice[i]);
		}
		sc.close();
	}
}
