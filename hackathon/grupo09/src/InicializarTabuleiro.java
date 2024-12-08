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