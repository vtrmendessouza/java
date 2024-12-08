public class InicializarTabuleiro {

    static char[][] inicializarTabuleiro(char[][] tabuleiro) {
  
        //Inicializa o tabuleiro com o caractere ' ' (espaço).
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
        return tabuleiro;
    }
}