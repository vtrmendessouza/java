public class TeveGanhadorDiagonalPrincipal {

    // Verifica se o jogador ganhou na diagonal principal
    static boolean teveGanhadorDiagonalPrincipal(char[][] tabuleiro, char caractereJogador) {

        // Verifica se a diagonal principal está toda preenchida com o caractere do jogador
        return tabuleiro[0][0] == caractereJogador && 
            tabuleiro[1][1] == caractereJogador && 
            tabuleiro[2][2] == caractereJogador;
    }
}