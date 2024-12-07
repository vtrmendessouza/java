import java.util.Scanner;

public class ObterCaractereUsuario {

    // Constante com os caracteres aceitos
    private static final char[] CARACTERES_IDENTIFICADORES_ACEITOS = {'X', 'O', 'A', 'B', 'C'};

    //Solicita ao usuário um caractere para representá-lo no jogo.
    static char obterCaractereUsuario(Scanner teclado) {
        char caractereEscolhido;
        boolean caractereValido = false;

        do {
            // Solicita ao usuário para escolher um caractere
            System.out.print("Escolha um caractere para representar você (X, O, A, B, C): ");
            String entrada = teclado.nextLine();

            // Valida se o usuário digitou apenas um caractere
            if (entrada.length() == 1) {
                caractereEscolhido = entrada.charAt(0);

                // Verifica se o caractere está na lista de permitidos
                for (char caracterePermitido : CARACTERES_IDENTIFICADORES_ACEITOS) {
                    if (caractereEscolhido == caracterePermitido) {
                        caractereValido = true;
                        break;
                    }
                }
                if (!caractereValido) {
                    System.out.println("Caractere inválido! Escolha um dos caracteres permitidos.");
                }
            } else {
                System.out.println("Entrada inválida! Por favor, digite apenas um caractere.");
                caractereEscolhido = ' '; // Apenas inicializa para evitar erro de compilação
            }
        } while (!caractereValido); // Continua até que o caractere seja válido

        return caractereEscolhido;
    }
}