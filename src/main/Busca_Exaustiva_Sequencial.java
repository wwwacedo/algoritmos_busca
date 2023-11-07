package main;

import java.util.Scanner;

// 1
public class Busca_Exaustiva_Sequencial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int baseDeDados[] = new int[100];
		System.out.println("Digite números inteiros POSITIVOS e -1 para SAIR: ");
		int item = sc.nextInt();
		for(int i = 0; item >=0; i++) {
			baseDeDados[i] = item;
			item = sc.nextInt();
		}

		int encontrados[] = new int[100];

		System.out.println("Digite a chave procurada: ");
		int chaveProcurada = sc.nextInt();
		int cont = 0;
		for ( int i = 0; i < baseDeDados.length; i++) {
			if(baseDeDados[i] == chaveProcurada) {
				encontrados[cont] = i;
				cont++;
			}
		}

		System.out.println("Posição(ões) onde chave(s) foi(ram) encontrada(s): ");
		for (int i = 0; i < cont; i++) {
			System.out.println(encontrados[i]);
		}

		sc.close();
	}
}
