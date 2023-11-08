package main;

public class TesteBuscaSimples {

	public static void main(String[] args) {

		int[] vetor = { 10, 20, 30, 40, 50 }; // posições 0,1,2,3,4

		int alvo = 30; // Valor a ser encontrado

		int tamanhoVetor = 5; // Tamanho do vetor (número de elementos)

		// Loop para buscar o valor no vetor
		
		// *** BUSCA SEQUENCIAL ***
		int i = 0;
		while(i < tamanhoVetor && (vetor[i] != alvo)) i++;
		int posicao = -1;
		if(i < tamanhoVetor) posicao = i;
		System.out.println("\n - Resultado da busca sequencial: ");
		if (posicao >= 0) {
			System.out.println("A primeira ocorrência do elemento " + alvo + " foi encontrado na posição " + posicao + " do vetor.");
		} else {
			System.out.println("O elemento " + alvo + " não foi encontrado no vetor.");
		}


		// *** BUSCA SEQUENCIAL EXAUSTIVA ***
		int cont = 0;
		int encontrados[] = new int[tamanhoVetor];	
		for (int j = 0; j < tamanhoVetor; j++) {
			if(vetor[j] == alvo) {
				encontrados[cont] = j;
				cont++;
			}
		}
		System.out.println("\n - Resultado da busca sequencial exaustiva: ");
		System.out.println("O elemento " + alvo + " foi encontrado na(s) posição(ões): ");
		for(int j = 0; j < cont; j++) {
			System.out.println(encontrados[j]);
		}
	}

}