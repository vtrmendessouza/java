//Vitor Mendes
public class TeveEmpate {

    // Percorre todo o tabuleiro e verifica se há algum espaço vazio
    static boolean teveEmpate(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}