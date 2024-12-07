public class TeveGanhadorDiagonalSecundaria {

    // Verifica se o jogador ganhou na diagonal secundária
    static boolean teveGanhadorDiagonalSecundaria(char[][] tabuleiro, char caractereJogador) {
        // Verifica se a diagonal secundária está toda preenchida com o caractere do jogador
        return tabuleiro[0][2] == caractereJogador && 
            tabuleiro[1][1] == caractereJogador && 
            tabuleiro[2][0] == caractereJogador;
    }
}