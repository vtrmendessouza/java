import java.util.Random;
import java.util.Scanner;

public class ObterJogadaComputador {

    //Obtém a jogada do computador sorteando uma posição livre.
    //@param posicoesLivres = String com as posições livres no formato "xy;xy;..."
    //@param teclado = Objeto Scanner (não utilizado, mas incluído na assinatura).
    //@return Vetor de inteiros contendo [linha, coluna] no formato de índice.
 
    static int[] obterJogadaComputador(String posicoesLivres, Scanner teclado) {

        // Divide as posições livres em um vetor de strings
        String[] vetorPosicoesLivres = posicoesLivres.split(";");

        // Gera um número aleatório dentro do intervalo de posições livres
        Random random = new Random();
        int indiceSorteado = random.nextInt(vetorPosicoesLivres.length);

        // Obtém a posição sorteada no formato "xy"
        String jogadaSorteada = vetorPosicoesLivres[indiceSorteado];

        // Converte a jogada no formato "xy" para um vetor de inteiros [x, y]
        return converterJogadaStringParaVetorInt(jogadaSorteada);
    }
    //Converte uma string no formato "xy" para um vetor de inteiros [x, y].
    //@param jogada = String no formato "xy", onde x é a linha e y é a coluna.
    //@return Vetor de inteiros contendo [linha, coluna].
 
    static int[] converterJogadaStringParaVetorInt(String jogada) {
        int linha = Character.getNumericValue(jogada.charAt(0));
        int coluna = Character.getNumericValue(jogada.charAt(1));
        return new int[] { linha, coluna };
    }
}