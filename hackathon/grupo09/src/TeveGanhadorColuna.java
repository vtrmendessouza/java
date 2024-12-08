//Vitor Mendes
public class TeveGanhadorColuna {

    // Verifica se toda a coluna está preenchida com o caractere do jogador
    static boolean teveGanhadorColuna(char[][] tabuleiro, char caractereJogador) {
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][0] != caractereJogador) {
                return false;
            }
        }
        return true;
    }
}