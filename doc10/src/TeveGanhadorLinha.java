//Vitor Mendes
public class TeveGanhadorLinha {

    // Verifica se toda a linha está preenchida com o caractere do jogador
    static boolean teveGanhadorLinha(char[][] tabuleiro, char caractereJogador) {
        for (int j = 0; j < tabuleiro.length; j++) {
            if (tabuleiro[0][j] != caractereJogador) {
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