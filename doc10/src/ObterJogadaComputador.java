import java.util.Random;

public class ObterJogadaComputador {

    static int[] obterJogadaComputador(String posicoesLivres) {

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
    // TODO Auto-generated method stub
    private static int[] converterJogadaStringParaVetorInt(String jogadaSorteada) {
        throw new UnsupportedOperationException("Unimplemented method 'converterJogadaStringParaVetorInt'");
    }
}