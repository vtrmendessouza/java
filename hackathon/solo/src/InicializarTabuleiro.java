public class InicializarTabuleiro {

    //Inicializa o tabuleiro 3x3 com o caractere ' ' (espaço).
    //@param tabuleiro = Matriz de caracteres representando o tabuleiro.
    //@return O = tabuleiro inicializado.
    static char[][] inicializarTabuleiro(char[][] tabuleiro) {
        // Percorre todas as linhas e colunas do tabuleiro
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                // Define cada posição com o caractere ' ' (espaço)
                tabuleiro[i][j] = ' ';
            }
        }
        // Retorna o tabuleiro inicializado
        return tabuleiro;
    }
}