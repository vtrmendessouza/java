import java.util.Scanner;

public class ObterCaractereComputador {

    // Constante com os caracteres aceitos
    final static String CARACTERES_IDENTIFICADORES_ACEITOS = "XO0UC";

    //Solicita ao usuário um caractere para representar o computador.
    static char obterCaractereComputador(Scanner teclado, char caractereUsuario) {
        char caractereEscolhido;
        boolean caractereValido = false;

        do {
            // Solicita ao usuário para escolher um caractere para o computador
            System.out.print("Escolha um caractere para representar o computador (X, O, 0, U, C): ");
            String entrada = teclado.nextLine().toUpperCase();

            // Verifica se o usuário digitou apenas um caractere
            if (entrada.length() == 1) {
                caractereEscolhido = entrada.charAt(0);

                // Verifica se o caractere está na lista de permitidos e não é igual ao do usuário
                if (caractereEscolhido != caractereUsuario) {
                    for (int i = 0; i < CARACTERES_IDENTIFICADORES_ACEITOS.length(); i++) {
                        if (caractereEscolhido == CARACTERES_IDENTIFICADORES_ACEITOS.charAt(i)) {
                            caractereValido = true;
                            break;
                        }
                    }
                    if (!caractereValido) {
                        System.out.println("Caractere inválido! Escolha um dos caracteres permitidos.");
                    }
                } else {
                    System.out.println("Caractere inválido! O computador não pode usar o mesmo caractere que você.");
                }
            } else {
                System.out.println("Entrada inválida! Por favor, digite apenas um caractere.");
                
                // Apenas inicializa para evitar erro de compilação
                caractereEscolhido = ' ';
            }
            
        // Continua até que o caractere seja válido
        } while (!caractereValido);

        return caractereEscolhido;
    }
}