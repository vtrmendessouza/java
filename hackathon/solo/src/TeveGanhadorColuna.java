public class TeveGanhadorColuna {

    // Verifica se o jogador ganhou em alguma coluna
    static boolean teveGanhadorColuna(char[][] tabuleiro, char caractereJogador) {
        // Verifica se todas as células de uma coluna estão preenchidas com o caractere do jogador
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == caractereJogador && 
                tabuleiro[1][j] == caractereJogador && 
                tabuleiro[2][j] == caractereJogador) {
                return true;  // Ganhou na coluna
            }
        }
        return false;  // Não ganhou em nenhuma coluna
    }
}