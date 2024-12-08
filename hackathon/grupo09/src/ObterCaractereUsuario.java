//Luis Filipe
import java.util.Scanner;

public class ObterCaractereUsuario {

    final static String CARACTERES_IDENTIFICADORES_ACEITOS = "XO0UC";

    static char obterCaractereUsuario(Scanner teclado) {
        
        char caractere;
        do {
            System.out.print("Digite o caractere que deseja utilizar (X, O, 0, U, C): ");
            caractere = teclado.next().toUpperCase().charAt(0);

            if (CARACTERES_IDENTIFICADORES_ACEITOS.indexOf(caractere) == -1) {
                System.out.println("Caractere inválido! Escolha apenas entre: " + CARACTERES_IDENTIFICADORES_ACEITOS);
            }
        } while (CARACTERES_IDENTIFICADORES_ACEITOS.indexOf(caractere) == -1);
        return caractere;
    }
}