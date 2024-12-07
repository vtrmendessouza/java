public class RetornarTabuleiroAtualizado {

    static char[][] retornarTabuleiroAtualizado(char[][] tabuleiro, int[] jogada, char caractereJogador) {

        // Atualiza o tabuleiro na posição indicada pela jogada
        tabuleiro[jogada[0]][jogada[1]] = caractereJogador;
    
        // Retorna o tabuleiro atualizado
        return tabuleiro;
    }
}