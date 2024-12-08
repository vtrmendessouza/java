//Maria Eduarda
import java.util.Random;
import java.util.Scanner;

public class ObterJogadaComputador {
    
    static int[] ObterJogadaComputadoradaComputador(String posicoesLivres, Scanner teclado) {
        
        String[] vetorPosicoes = posicoesLivres.split(";");
        Random random = new Random();
        int indiceSorteado = random.nextInt(vetorPosicoes.length);
        String jogadaSorteada = vetorPosicoes[indiceSorteado];
        
        return converterJogadaStringParaVetorInt(jogadaSorteada);
        //lembrando que precisa da funcao 7 pra executar essa :(converterstringpravetorint), senao nao vai pegar 
    }
    // TODO Auto-generated method stub
    private static int[] converterJogadaStringParaVetorInt(String jogadaSorteada) {
        throw new UnsupportedOperationException("Unimplemented method 'converterJogadaStringParaVetorInt'");
    }
}