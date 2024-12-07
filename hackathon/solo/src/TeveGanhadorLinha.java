public class TeveGanhadorLinha {

    // Verifica se o jogador ganhou em alguma linha
    static boolean teveGanhadorLinha(char[][] tabuleiro, char caractereJogador) {

        // Verifica se todas as células de uma linha estão preenchidas com o caractere do jogador
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == caractereJogador && 
                tabuleiro[i][1] == caractereJogador && 
                tabuleiro[i][2] == caractereJogador) {
                return true;  // Ganhou na linha
            }
        }
        return false;  // Não ganhou em nenhuma linha
    }
}