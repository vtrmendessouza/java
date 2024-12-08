//Maria Eduarda

import java.util.Scanner;

public class ProcessarVezUsuario {

    static char[][] processarVezUsuario(Scanner teclado, char[][] tabuleiro, char caractereUsuario) {

        System.out.println("Vez do usuário: ");
        String posicoesLivres = obterPosicoesLivres(tabuleiro);
        int[] jogada = obterJogadaUsuario(posicoesLivres, teclado);
        tabuleiro = retornarTabuleiroAtualizado(tabuleiro, jogada, caractereUsuario);
        return tabuleiro;
    }
    // TODO Auto-generated method stub
    private static char[][] retornarTabuleiroAtualizado(char[][] tabuleiro, int[] jogada, char caractereUsuario) {
        throw new UnsupportedOperationException("Unimplemented method 'retornarTabuleiroAtualizado'");
    }
    // TODO Auto-generated method stub
    private static int[] obterJogadaUsuario(String posicoesLivres, Scanner teclado) {
        throw new UnsupportedOperationException("Unimplemented method 'obterJogadaUsuario'");
    }
    // TODO Auto-generated method stub
    private static String obterPosicoesLivres(char[][] tabuleiro) {
        throw new UnsupportedOperationException("Unimplemented method 'obterPosicoesLivres'");
    }
}
/*
Descrição: Utilizado para realizar as ações necessárias para processar a vez
do usuário jogar. Este método deve exibir uma mensagem que é a vez do usuário
jogar. Este método é encarregado de obter a jogada do usuário através do
método obterJogadaUsuario, depois realizar a atualização do tabuleiro através
do método retornarTabuleiroAtualizado e retornar o tabuleiro atualizado
Nível de complexidade: 4 de 10
*/