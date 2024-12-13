public class TeveGanhador {

    static boolean teveGanhador(char[][] tabuleiro, char caractereJogador) {
    
        if (teveGanhadorLinha(tabuleiro, caractereJogador)) {
            return true;
        }
        if (teveGanhadorColuna(tabuleiro, caractereJogador)) {
            return true;
        }
        if (teveGanhadorDiagonalPrincipal(tabuleiro, caractereJogador)) {
            return true;
        }
        if (teveGanhadorDiagonalSecundaria(tabuleiro, caractereJogador)) {
            return true;
        }
        return false;
    }
    // TODO Auto-generated method stub
    private static boolean teveGanhadorDiagonalSecundaria(char[][] tabuleiro, char caractereJogador) {
        throw new UnsupportedOperationException("Unimplemented method 'teveGanhadorDiagonalSecundaria'");
    }
    // TODO Auto-generated method stub
    private static boolean teveGanhadorDiagonalPrincipal(char[][] tabuleiro, char caractereJogador) {
        throw new UnsupportedOperationException("Unimplemented method 'teveGanhadorDiagonalPrincipal'");
    }
    // TODO Auto-generated method stub
    private static boolean teveGanhadorColuna(char[][] tabuleiro, char caractereJogador) {
        throw new UnsupportedOperationException("Unimplemented method 'teveGanhadorColuna'");
    }
    // TODO Auto-generated method stub
    private static boolean teveGanhadorLinha(char[][] tabuleiro, char caractereJogador) {
        throw new UnsupportedOperationException("Unimplemented method 'teveGanhadorLinha'");
    }
}