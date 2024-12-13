public class ExibirTabuleiro {
    
    static void exibirTabuleiro(char[][] tabuleiro) {

    limparTela();
        
    // Exibe o tabuleiro no formato de grade
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                
                // Exibe o conteúdo da célula
                System.out.print(" " + tabuleiro[i][j] + " ");
                if (j < tabuleiro[i].length - 1) {
                
                    // Exibe separador entre colunas
                    System.out.print("|");
                }
            }
            // Pula para a próxima linha após uma linha completa
            System.out.println();
    
            if (i < tabuleiro.length - 1) {
                
                // Exibe separador entre linhas
                System.out.println("---+---+---");
            }
        }
    }
    // TODO Auto-generated method stub
    private static void limparTela() {
        throw new UnsupportedOperationException("Unimplemented method 'limparTela'");
    }
}