public class ExibirTabuleiro {

    static void exibirTabuleiro(char[][] tabuleiro) {
        // Limpa a tela antes de exibir o tabuleiro
        limparTela();
    
        // Exibe o conteúdo do tabuleiro no formato de uma grade 3x3
        System.out.println("Tabuleiro:");
        
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < tabuleiro[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < tabuleiro.length - 1) {
                System.out.println("---------");
            }
        }
    }

    //EXTRA:
    private static void limparTela() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'limparTela'");
    }
}