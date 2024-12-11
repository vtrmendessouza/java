//Vitor Mendes
public class TeveGanhadorDiagonalSecundaria {

    // Verifica se a diagonal secundária está toda preenchida com o caractere do jogador
    static boolean teveGanhadorDiagonalSecundaria(char[][] tabuleiro, char caractereJogador) {
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][tabuleiro.length - 1 - i] != caractereJogador) {
                return false;
            }
        }
        return true;
    }
}
/*
Descrição: Todos os métodos abaixo, teveGanhador... funcionam da mesma forma.
Recebem como parametro o tabuleiro e o caractereJogador. Cada um dos métodos
verificam no tabuleiro se o caractere do jogador está presente em todas as
posições, ou seja, o método teveGanhadorLinha verifica em todas as posicoes
de uma determinada linha se elas estão preenchidas com o caractere informado
no caractereJogador. Se estiver presente retorna true, caso contrário retorna
false.
Nível de complexidade: 4 de 10
*/