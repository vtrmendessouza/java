//Nathan Vinicius
public class ProcessarVezComputador {
    
    static char[][] processarVezComputador(char[][] tabuleiro, char caractereComputador) {

        int[] jogada = obterjogadaComputador();
        while (tabuleiro[jogada[0]][jogada[1]] != ' ') {
        jogada = obterJogadaComputador();
        }
        tabuleiro = retornarTabuleiroAtualizado(tabuleiro, jogada, caractereComputador);
        return tabuleiro;
    }
    // TODO Auto-generated method stub
    private static char[][] retornarTabuleiroAtualizado(char[][] tabuleiro, int[] jogada, char caractereComputador) {
        throw new UnsupportedOperationException("Unimplemented method 'retornarTabuleiroAtualizado'");
    }
    // TODO Auto-generated method stub
    private static int[] obterJogadaComputador() {
        throw new UnsupportedOperationException("Unimplemented method 'obterJogadaComputador'");
    }
    // TODO Auto-generated method stub
    private static int[] obterjogadaComputador() {
        throw new UnsupportedOperationException("Unimplemented method 'obterjogadaComputador'");
    }
}