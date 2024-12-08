//Nathan Vinicius
public class RetornarTabuleiroAtualizado {

    static char[][] retornarTabuleiroAtualizado(char[][] tabuleiro, int[] jogada, char caractereJogador) {
        
        tabuleiro[jogada[0]][jogada[1]] = caractereJogador;
        return tabuleiro;
    }    
}