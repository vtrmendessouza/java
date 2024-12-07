public class TeveGanhadorColuna {

    // Verifica se o jogador ganhou em alguma coluna
    static boolean teveGanhadorColuna(char[][] tabuleiro, char caractereJogador) {

        // Verifica se todas as células de uma coluna estão preenchidas com o caractere do jogador
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i] == caractereJogador && 
                tabuleiro[1][i] == caractereJogador && 
                tabuleiro[2][i] == caractereJogador) {
                return true;  // Ganhou na coluna
            }
        }
        return false;  // Não ganhou em nenhuma coluna
    }
}