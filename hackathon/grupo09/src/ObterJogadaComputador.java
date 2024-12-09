//Maria Eduarda
import java.util.Random;

public class ObterJogadaComputador {
    
    static int[] obterJogadaComputador(String posicoesLivres) {
        
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
/*
Descrição: Utilizado para obter do computador a linha e a coluna sorteada.
Para isto o método utiliza as posições livres que ele recebeu como parametro.
Como as posições livres estão no formato de string, uma sugestão é conveter a
lista de pares linhacoluna que estão separados por ; em um vetor de String.
Pense em utilizar o método split. A conversão para um vetor de string será
útil para o próximo passo que é sortear uma posição livre.
Para sortear uma das posições no vetor de posições livres, utilize o método
random.nextInt() para sortear um número que esteja no intervalo de 0 até a
quantidade de posições no vetor de posições livres. Pesquise pelo método
random.nextInt() na internet para entender como ele funciona.
Após o random sortear um número, utilize este número como o valor da posição
do índice para acessar a jogada dentro do vetor de jogadas livres.
Ao realizar este procedimento você terá uma jogada no formato xy onde x é
a linha livre e y a coluna livre. Como o método obterJogadaComputador
precisa devolver um vetor de inteiro é necessário converter esta string para
um vetor de inteiro. Utilize para isto o método
converterJogadaStringParaVetorInt(). Após a conversão, devolva o vetor de
inteiro através do comando return. Para o nível de complexidade inicial,
com esta implementação o computador não terá "inteligência" para se defender
e nem para tentar ganhar.
Nível de complexidade: 6 de 10
*/