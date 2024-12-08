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