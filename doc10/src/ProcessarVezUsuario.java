import java.util.Scanner;

public class ProcessarVezUsuario {

    static char[][] processarVezUsuario(Scanner teclado, char[][] tabuleiro, char caractereUsuario) {
     
        System.out.println("É a sua vez:");
    
        int[] jogada = obterJogadaUsuario(retornarPosicoesLivres(tabuleiro), teclado, tabuleiro.length);
                
        tabuleiro = retornarTabuleiroAtualizado(tabuleiro, jogada, caractereUsuario);
        return tabuleiro;
    }
    // TODO Auto-generated method stub
    private static char[][] retornarTabuleiroAtualizado(char[][] tabuleiro, int[] jogada, char caractereUsuario) {
        throw new UnsupportedOperationException("Unimplemented method 'retornarTabuleiroAtualizado'");
    }
    // TODO Auto-generated method stub
    private static int[] obterJogadaUsuario(Object retornarPosicoesLivres, Scanner teclado, int length) {
    throw new UnsupportedOperationException("Unimplemented method 'obterJogadaUsuario'");
    }
    // TODO Auto-generated method stub
    private static Object retornarPosicoesLivres(char[][] tabuleiro) {
        throw new UnsupportedOperationException("Unimplemented method 'retornarPosicoesLivres'");
    }
}