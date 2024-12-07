import java.util.Scanner;

public class ObterCaractereUsuario {

    // Constante com os caracteres aceitos
    final static String CARACTERES_IDENTIFICADORES_ACEITOS = "XO0UC";

    //Solicita ao usuário um caractere para representá-lo no jogo.
    static char obterCaractereUsuario(Scanner teclado) {
        char caractereEscolhido;
        boolean caractereValido = false;

        do {
            // Solicita ao usuário para escolher um caractere
            System.out.print("Escolha um caractere para representar você (X, O, 0, U, C): ");
            String entrada = teclado.nextLine().toUpperCase();

            // Valida se o usuário digitou apenas um caractere
            if (entrada.length() == 1) {
                caractereEscolhido = entrada.charAt(0);

                // Verifica se o caractere está na lista de permitidos
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
                System.out.println("Entrada inválida! Por favor, digite apenas um caractere.");
                
                // Apenas inicializa para evitar erro de compilação
                caractereEscolhido = ' ';
            }
        
        // Continua até que o caractere seja válido
        } while (!caractereValido);

        return caractereEscolhido;
    }
}