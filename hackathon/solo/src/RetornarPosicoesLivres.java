public class RetornarPosicoesLivres {

    static String retornarPosicoesLivres(char[][] tabuleiro) {
        StringBuilder posicoesLivres = new StringBuilder();  // Usando StringBuilder para construir a string
        
        // Percorrer o tabuleiro para encontrar as posições livres
        for (int i = 0; i < tabuleiro.length; i++) {  // Percorre as linhas
            for (int j = 0; j < tabuleiro[i].length; j++) {  // Percorre as colunas
                // Se a posição estiver livre (caractere ' '), adiciona à lista de posições livres
                if (tabuleiro[i][j] == ' ') {
                    posicoesLivres.append(i).append(j).append(";");  // Adiciona a posição no formato xy
                }
            }
        }
        // Se a lista de posições livres não estiver vazia, remove o último ponto e vírgula
        if (posicoesLivres.length() > 0) {
            posicoesLivres.deleteCharAt(posicoesLivres.length() - 1);
        }
        // Retorna a string com as posições livres
        return posicoesLivres.toString();
    }
}