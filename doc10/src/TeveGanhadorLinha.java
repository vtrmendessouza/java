public class TeveGanhadorLinha {

    static boolean teveGanhadorLinha(char[][] tabuleiro, char caractereJogador) {
        
        // Verifica se toda a linha está preenchida com o caractere do jogador
        for (int j = 0; j < tabuleiro.length; j++) {
            if (tabuleiro[0][j] != caractereJogador) {
                return false;
            }
        }
        return true;
    }
}