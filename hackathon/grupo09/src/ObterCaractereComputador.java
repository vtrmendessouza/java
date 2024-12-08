//Eduardo Santos
import java.util.Scanner;

public class ObterCaractereComputador {

    // Define os caracteres aceitos
    private static final char[] CARACTERES_IDENTIFICADORES_ACEITOS = {'X', 'O', 'A', 'B', 'C'};

    static char obterCaractereComputador(Scanner teclado, char caractereUsuario) {
        char caractereComputador;

        while (true) {
            System.out.println("Digite o caractere para o computador (X, O, A, B, C):");
            caractereComputador = teclado.next().toUpperCase().charAt(0);

            // Verifica se o caractere está na lista de aceitos e é diferente do caractere do usuário
            if (caractereEhValido(caractereComputador) && caractereComputador != caractereUsuario) {
                break; // Sai do loop se for válido
            } else {
                System.out.println("Caractere inválido ou já escolhido pelo usuário. Tente novamente.");
            }
        }
    return caractereComputador;
    }
    private static boolean caractereEhValido(char caractere) {
        for (char c : CARACTERES_IDENTIFICADORES_ACEITOS) {
            if (c == caractere) {
                return true;
            }
        }
    return false;
    }
}
/*
funciona assim :
Constante de caracteres aceitos: CARACTERES_IDENTIFICADORES_ACEITOS define quais caracteres podem ser escolhidos.
Loop de validação:
Solicita ao usuário que insira um caractere para o computador.
Verifica se o caractere está na lista de caracteres aceitos e se é diferente do caractere já escolhido pelo usuário.
Método auxiliar: caractereEhValido verifica se o caractere pertence à lista de caracteres permitidos.
Saída: O caractere válido é retornado e exibido.
*/