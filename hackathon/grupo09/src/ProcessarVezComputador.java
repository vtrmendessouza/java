//Nathan Vinicius
public class ProcessarVezComputador {
    
    static char[][] processarVezComputador(char[][] tabuleiro, char caractereComputador) {
        
        String posicoesLivres = retornarPosicoesLivres(tabuleiro);
        System.out.println("Vez do computador: ");
        int[] jogada = obterJogadaComputador(posicoesLivres);
        tabuleiro = retornarTabuleiroAtualizado(tabuleiro, jogada, caractereComputador);
        return tabuleiro;
    }
    // TODO Auto-generated method stub
    private static char[][] retornarTabuleiroAtualizado(char[][] tabuleiro, int[] jogada, char caractereComputador) {
    throw new UnsupportedOperationException("Unimplemented method 'retornarTabuleiroAtualizado'");
    }
    // TODO Auto-generated method stub
    private static int[] obterJogadaComputador(String posicoesLivres) {
    throw new UnsupportedOperationException("Unimplemented method 'obterJogadaComputador'");
    }
    // TODO Auto-generated method stub
    private static String retornarPosicoesLivres(char[][] tabuleiro) {
    throw new UnsupportedOperationException("Unimplemented method 'retornarPosicoesLivres'");
    }
}
/*
Descrição: Utilizado para realizar as ações necessárias para processar a vez
do computador jogar. Este método é encarregado de obter a jogada do
computador através do método obterJogadaComputador, depois realizar a
atualização do tabuleiro através do método retornarTabuleiroAtualizado e
retornar o tabuleiro atualizado
Nível de complexidade: 4 de 10
*/