//Vitor Mendes
public class InicializarTabuleiro {

    //Inicializa o tabuleiro com o caractere ' ' (espaço).
    static char[][] inicializarTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
        return tabuleiro;
    }
}
/*
Descrição: Utilizado para iniciar a matriz/tabuleiro com o caractere ' ' espaço, 
no início do jogo. Matrizes de char precisam ter um valor diferente de '' vazio. 
A idéia é, se tiver ' ' espaço, a posição está livre.Qualquer outro caractere presente 
na posição, representa o caractere do jogador em questão: usuário ou computador. 
Um exemplo seria, 'X' para usuário e 'O' para computador. Para o primeiro nível
de complexidade considere um tabuleiro apenas de tamanho 3x3, 3 linhas e 3 colunas.
Depois de atualizar o tabuleiro com os valores, retorne o mesmo com o comando return
Nível de complexidade: 3 de 10
*/