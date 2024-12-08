public class TeveGanhadorDiagonalSecundaria {

    static boolean teveGanhadorDiagonalSecundaria(char[][] tabuleiro, char caractereJogador) {
        
        // Verifica se a diagonal secundária está toda preenchida com o caractere do jogador
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][tabuleiro.length - 1 - i] != caractereJogador) {
                return false;
            }
        }
        return true;
    }
}