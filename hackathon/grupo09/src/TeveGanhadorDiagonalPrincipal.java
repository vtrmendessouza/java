//Vitor Mendes
public class TeveGanhadorDiagonalPrincipal {

    // Verifica se a diagonal principal está toda preenchida com o caractere do jogador
    static boolean teveGanhadorDiagonalPrincipal(char[][] tabuleiro, char caractereJogador) {
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][i] != caractereJogador) {
                return false;
            }
        }
        return true;
    }
}