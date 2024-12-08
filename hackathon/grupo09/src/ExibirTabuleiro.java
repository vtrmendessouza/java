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