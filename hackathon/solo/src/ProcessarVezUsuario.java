import java.util.Scanner;

public class ProcessarVezUsuario {

    //Realiza as ações necessárias para processar a vez do usuário jogar.
    static char[][] processarVezUsuario(Scanner teclado, char[][] tabuleiro, char caractereUsuario) {

        // Exibe mensagem indicando que é a vez do usuário
        System.out.println("É a sua vez, usuário! Faça sua jogada.");

        // Obtém a jogada do usuário
        int[] jogada = obterJogadaUsuario(retornarPosicoesLivres(tabuleiro), teclado);

        // Atualiza o tabuleiro com a jogada do usuário
        tabuleiro = retornarTabuleiroAtualizado(tabuleiro, jogada, caractereUsuario);

        // Retorna o tabuleiro atualizado
        return tabuleiro;
    }

    //EXTRA********************************************
    private static char[][] retornarTabuleiroAtualizado(char[][] tabuleiro, int[] jogada, char caractereUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retornarTabuleiroAtualizado'");
    }
    private static int[] obterJogadaUsuario(Object retornarPosicoesLivres, Scanner teclado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterJogadaUsuario'");
    }
    private static Object retornarPosicoesLivres(char[][] tabuleiro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retornarPosicoesLivres'");
    }
}