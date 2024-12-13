public class RetornarPosicoesLivres {

    static String retornarPosicoesLivres(char[][] tabuleiro) {
        
        StringBuilder posicoesLivres = new StringBuilder();
        
        // Percorrer o tabuleiro para encontrar as posições livres
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                
                // Se a posição estiver livre (caractere ' '), adiciona à lista de posições livres
                if (tabuleiro[i][j] == ' ') {
                    
                    // Adiciona a posição no formato xy
                    posicoesLivres.append(i).append(j);
                }
            }
        }
        return posicoesLivres.toString();
    }
}