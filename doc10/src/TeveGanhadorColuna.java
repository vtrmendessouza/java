public class TeveGanhadorColuna {

    static boolean teveGanhadorColuna(char[][] tabuleiro, char caractereJogador) {
        
        // Verifica se toda a coluna está preenchida com o caractere do jogador
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][0] != caractereJogador) {
                return false;
            }
        }
        return true;
    }
}