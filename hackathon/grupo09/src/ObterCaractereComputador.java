//Eduardo Santos
import java.util.Scanner;

public class ObterCaractereComputador {

    // Define os caracteres aceitos
    final static String CARACTERES_IDENTIFICADORES_ACEITOS = "XO0UC";

    static char obterCaractereComputador(Scanner teclado, char caractereUsuario) {
        char caractereComputador;

        while (true) {
            System.out.print("Digite o caractere para o computador (X, O, 0, U, C): ");
            caractereComputador = teclado.next().toUpperCase().charAt(0);

            // Verifica se o caractere está na lista aceita e é diferente do caractere do usuário
            if (CARACTERES_IDENTIFICADORES_ACEITOS.indexOf(caractereComputador) != -1 && caractereComputador != caractereUsuario) {
                break; // Sai do loop se for válido
            } else {
                System.out.println("Caractere inválido ou já escolhido pelo usuário. Tente novamente.");
            }
        }
        return caractereComputador;
    }
}
/*
Descrição: Utilizado para obter no início do jogo qual o caractere que o usuário quer
utilizar para representar o computador. Este método recebe o teclado e recebe o caractere
que foi configurado para o usuário, pois o usuário e o computador não podem jogar com 
o mesmo caractere. Por exemplo, se o usuário configurou para ele o caractere X ele não pode
escolher o X como o caractere também para o computador. Neste método apenas os seguintes 
caracteres definidos pela constante CARACTERES_IDENTIFICADORES_ACEITOS devem ser aceitos. 
Lembre-se que o caractere armazenado em caractereUsuario não pode ser aceito.
Após realizar a leitura do caractere pelo teclado e validá-lo, faça o return deste caractere.
Nível de complexidade: 3 de 10
*/