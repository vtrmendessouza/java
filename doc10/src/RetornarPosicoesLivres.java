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
Descrição: Utilizado para identificar a lista de posições livres no tabuleiro. Esta lista
é uma string no formato xy. Onde x é a linha e y a coluna. Se existir mais de uma posição 
livre, teremos uma lista de valores xy separados por ; exemplo: 00;01;20; Neste exemplo 
as posições linha 0 e coluna 0; linha 0 e coluna 1; linha 2 e coluna 0 estão livres. 
Lembre-se que os índices nas matrizes iniciam em 0. Para o primeiro nível
de complexidade considere um tabuleiro apenas de tamanho 3x3, 3 linhas e 3 colunas.
Depois de montar a string retorne a mesma através do comando return
Nível de complexidade: 4 de 10
*/