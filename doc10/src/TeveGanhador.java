//Vitor Mendes
public class TeveGanhador {

    // Verifica se o jogador ganhou em alguma linha, coluna, diagonal peincipal ou secundária
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
/*
Descrição: Utilizado para verificar se o jogador identificado por
caractereJogador ganhou o jogo. No jogo da velha um usuário ganha
quando ele completa uma linha ou uma coluna ou uma diagonal. Assim
este método verifica todas as possibilidades. No entanto, este método
utiliza outros métodos para auxiliar nesta verificação. Para identificar
se o usuário em questão ganhou na linha, é invocado o método
teveGanhadorLinha(), para identificar na coluna é invocado o método
teveGanhadorColuna(), para identificar na diagonal principal é invocado
o método teveGanhadorDiagonalPrincipal() e para identificar na diagonal
secundária é utilizado o método teveGanhadorDiagonalSecundaria(). Se
o pelo menos um destes métodos retornar verdadeiro, o método teveGanhador
retorna true, caso contrário retorna false
Nível de complexidade: 4 de 10
*/