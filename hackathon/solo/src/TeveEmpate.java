public class TeveEmpate {

    static boolean teveEmpate(char[][] tabuleiro) {

        // Percorrer todo o tabuleiro e verificar se há algum espaço vazio
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == ' ') {

                    // Se encontrar algum espaço vazio, significa que o jogo não terminou em empate
                    return false;
                }
            }
        }
        // Se não encontrar espaços vazios, então o jogo terminou em empate
        return true;
    }
}