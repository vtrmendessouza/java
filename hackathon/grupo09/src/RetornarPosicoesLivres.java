//Nilson Eduardo
public class RetornarPosicoesLivres {

    static String retornarPosicoesLivres(char[][] tabuleiro) {
        StringBuilder posicoesLivres = new StringBuilder();

        // Percorre as linhas e colunas do tabuleiro
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                // Verifica se a posição está livre (representada por um espaço)
                if (tabuleiro[i][j] == ' ') {
                    // Adiciona a posição no formato "xy" ao resultado
                    posicoesLivres.append(i).append(j).append(";");
                }
            }
        }
        // Remove o último ";" caso exista
        if (posicoesLivres.length() > 0) {
            posicoesLivres.setLength(posicoesLivres.length() - 1);
        }
    return posicoesLivres.toString();
    }
}
/*
funciona assim :
Tabuleiro de entrada:
Representado por uma matriz 3x3 (char[][]), onde as células livres são identificadas por ' ' (espaço).
Percorre o tabuleiro:
Usa dois loops for para percorrer linhas e colunas.
Quando encontra uma posição livre (' '), adiciona sua coordenada xy ao StringBuilder, seguida de ';'.
Formatação final:
Remove o último ';' para evitar separadores extras no final da string.
Retorno:
Retorna a string formatada com as posições
*/