//Maria Eduarda
import java.util.Scanner;

public class ObterJogadaUsuario {

    static int[] obterJogadaUsuario(String posicoesLivres, Scanner teclado) {
        int[] jogada = new int[2];
        boolean jogadaAceita = false;

        while (!jogadaAceita) {
            try {
                System.out.println("Digite a linha e coluna com espaço entre eles");
                String entrada = teclado.nextLine();
                String[] partes = entrada.trim().split(" ");

                if (partes.length != 2) {
                    System.out.println("Entrada invalida! digite dois numeros entre espaço");
                    continue;
                }
                int linha = Integer.parseInt(partes[0]);
                int coluna = Integer.parseInt(partes[1]);

                if (linha > 0 && coluna > 0 && jogadaValida(posicoesLivres, linha, coluna)) {
                    jogada[0] = linha;
                    jogada[1] = coluna;
                    jogadaAceita = true;
                } else {
                    System.out.println("Jogada nao existe ou está indisponivel. Tente novameente!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada nao valida! digite numeros válidos!");
            }
        }
        return jogada;
    }
    // TODO Auto-generated method stub
    private static boolean jogadaValida(String posicoesLivres, int linha, int coluna) {
        throw new UnsupportedOperationException("Unimplemented method 'jogadaValida'");
    }
}
/*
Descrição: Utilizado para obter do usuário a linha e a coluna que ele deseja
jogar. Para isto o método deve exibir um mensagem informando que o jogador
deve digitar a linha e a coluna separados por um espaço. O método deve
realizar as validações necessárias para os casos do usuário não digitar
dois valores e também para o caso do usuário não digitar números.
O método deve garantir que o usuário digite os valores conforme solicitado
e devolva os valores lidos somente quando estes atenderam as regras.
Após a leitura dos valores de linha e coluna, o método deve retornar os
valores já no formato de índice, ou seja, no tabuleiro exibimos para o
usuário linha 1, linha 2, linha 3, coluna 1, coluna 2 e coluna 3. O
usuário digita os valores neste formato, no entanto o método ao retonar
os valores deve ajustar a linha 1 para o índice 0, a linha 2 para o índice
1 e assim sucessivamente, da mesma forma que as colunas.
Após a validação e ajuste dos índices, o método deve verificar se a jogada
do usuário está presente na lista de posicoesLivres que ele recebeu como
parametro. Para isto, o método faz a chamada ao método jogadaValida()
para determinar se a jogada é aceita. Se a jogada não for aceita, é exibido
uma mensagem informando que a jogada não é permitida e reinicia o processo de
leitura de uma nova jogada. Se a jogada for aceita deve devolver os
valores no formato de um vetor de inteiro de duas posições. No índice 0 deste
vetor, deve ser armazenado o valor da linha jogada pelo usuário e no índice 1
do vetor, deve ser armazenado a coluna jogada pelo usuário.
Nível de complexidade: 5 de 10
*/