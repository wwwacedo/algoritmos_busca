package main;

import java.util.Scanner;

// 2
public class Busca_Sequencial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i;

		int baseDeDados[] = new int[100];
		System.out.println("Digite números inteiros POSITIVOS ou -1 para SAIR: ");
		int item = sc.nextInt();
		for (i = 0; item >= 0; i++) {
			baseDeDados[i] = item;
			item = sc.nextInt();
		}

		System.out.println("Digite a chave procurada: ");
		int chaveProcurada = sc.nextInt();

		i = 0;
		while(i < baseDeDados.length && (baseDeDados[i] != chaveProcurada)) {
			i++;
		}

		int posicao = -1;
		if (i < baseDeDados.length) {
			posicao = i;
		}

		if (posicao >= 0) {
			System.out.println("Chave encontrada na posição " + posicao);
		} else {
			System.out.println("Chave não encontrada");
		}

		sc.close();

	}
}
