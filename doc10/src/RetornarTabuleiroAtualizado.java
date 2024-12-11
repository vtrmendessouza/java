//Nathan Vinicius
public class RetornarTabuleiroAtualizado {

    static char[][] retornarTabuleiroAtualizado(char[][] tabuleiro, int[] jogada, char caractereJogador) {
        
        tabuleiro[jogada[0]][jogada[1]] = caractereJogador;
        return tabuleiro;
    }    
}
/*
Descrição: Utilizado para atualizar o tabuleiro com o caractere que identifica o jogador.
Este método recebe o tabuleiro, um vetor jogada com duas posicoes. jogada[0] representa a 
linha escolhida pelo jogador. jogada[1] representa a coluna escolhida pelo jogador. Os valores
armazenados no vetor já deve estar no formato de índice, ou seja, se jogada[0] contiver o valor
1 e jogada[1] contiver o valor 2, significa que o índice/linha 1 e índice/coluna 2 da matriz devem
ser atualizados com o caractere informado na variável caractereJogador. Depois de atualizar o
tabuleiro, o mesmo deve ser retornado através do comando return
*/