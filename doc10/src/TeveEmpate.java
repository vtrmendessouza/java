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
/*
Descrição: Utilizado para analisar se ocorreu empate no jogo. Para o primeiro nível
de deficuldade, basta verificar se todas as posições do tabuleiro não estão preenchidas 
com o caractere ' '. Não se preocupe se teve ganhador, não é responsabilidade deste 
método esta análise. Sugestão: pense em utilizar a função retornarPosicoesLivres.
Retorne true se teve empate ou false se não teve
Nível de complexidade: 3 de 10
*/