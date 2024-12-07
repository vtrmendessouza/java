public class TeveGanhador {

    static boolean teveGanhador(char[][] tabuleiro, char caractereJogador) {

        // Verifica se o jogador ganhou em alguma linha
        if (teveGanhadorLinha(tabuleiro, caractereJogador)) {
            return true;
        }
        // Verifica se o jogador ganhou em alguma coluna
        if (teveGanhadorColuna(tabuleiro, caractereJogador)) {
            return true;
        }
        // Verifica se o jogador ganhou na diagonal principal
        if (teveGanhadorDiagonalPrincipal(tabuleiro, caractereJogador)) {
            return true;
        }
        // Verifica se o jogador ganhou na diagonal secundária
        if (teveGanhadorDiagonalSecundaria(tabuleiro, caractereJogador)) {
            return true;
        }
        // Se não encontrou ganhador, retorna false
            return false;
    }

    //EXTRA**********************************************
    private static boolean teveGanhadorDiagonalSecundaria(char[][] tabuleiro, char caractereJogador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'teveGanhadorDiagonalSecundaria'");
    }

    private static boolean teveGanhadorDiagonalPrincipal(char[][] tabuleiro, char caractereJogador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'teveGanhadorDiagonalPrincipal'");
    }

    private static boolean teveGanhadorColuna(char[][] tabuleiro, char caractereJogador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'teveGanhadorColuna'");
    }

    private static boolean teveGanhadorLinha(char[][] tabuleiro, char caractereJogador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'teveGanhadorLinha'");
    }
}