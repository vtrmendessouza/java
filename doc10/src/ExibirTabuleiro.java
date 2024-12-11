//Nathan Vinicius
public class ExibirTabuleiro {
    
    static void exibirTabuleiro(char[][] tabuleiro) {
        System.out.println("   0   1   2");
        for (int l = 0; l < 3; l++) {
            System.out.print(l + " ");
            for (int c = 0; c < 3; c++) {
                System.out.print(" " + tabuleiro[l][c] + " ");
                if (c < 2) System.out.print("|");
            }
            if (l < 2) System.out.println("\n  -----------");
        }
    }
}
/*
Descrição: Utilizado para imprimir o tabuleiro o conteúdo do tabuleiro na tela.
Recebe o tabuleiro como parametro e imprime o conteúdo de cada posição do tabuleiro
na tela. Imprimi o conteúdo no formato de uma grade. Para o primeiro nível
de complexidade considere um tabuleiro apenas de tamanho 3x3, 3 linhas e 3 colunas.
Nível de complexidade: 4 de 10
*/