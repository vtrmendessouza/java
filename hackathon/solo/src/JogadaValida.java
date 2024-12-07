import java.util.Scanner;

public class JogadaValida {

    // Constante com os caracteres aceitos
    private static final char[] CARACTERES_IDENTIFICADORES_ACEITOS = {'X', 'O', 'A', 'B', 'C'};

    //Solicita ao usuário um caractere para representar o computador.
    //@param teclado = Objeto Scanner para entrada de dados pelo teclado.
    //@param caractereUsuario = Caractere escolhido pelo usuário, que não pode ser repetido.
    //@return O = caractere escolhido para o computador.
    
    static char obterCaractereComputador(Scanner teclado, char caractereUsuario) {
        char caractereEscolhido;
        boolean caractereValido = false;

        do {
            // Solicita ao usuário para escolher um caractere para o computador
            System.out.print("Escolha um caractere para representar o computador (X, O, A, B, C): ");
            String entrada = teclado.nextLine();

            // Verifica se o usuário digitou apenas um caractere
            if (entrada.length() == 1) {
                caractereEscolhido = entrada.charAt(0);

                // Verifica se o caractere está na lista de permitidos e não é igual ao do usuário
                if (caractereEscolhido != caractereUsuario) {
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
                    System.out.println("Caractere inválido! O computador não pode usar o mesmo caractere que você.");
                }
            } else {
                System.out.println("Entrada inválida! Por favor, digite apenas um caractere.");
                caractereEscolhido = ' '; // Apenas inicializa para evitar erro de compilação
            }
        } while (!caractereValido); // Continua até que o caractere seja válido

        return caractereEscolhido;
    }

    //Método auxiliar para obter o caractere do usuário (implementado anteriormente).
    static char obterCaractereUsuario(Scanner teclado) {
        char caractereEscolhido;
        boolean caractereValido = false;

        do {
            System.out.print("Escolha um caractere para representar você (X, O, A, B, C): ");
            String entrada = teclado.nextLine();

            if (entrada.length() == 1) {
                caractereEscolhido = entrada.charAt(0);

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
                caractereEscolhido = ' ';
            }
        } while (!caractereValido);

        return caractereEscolhido;
    }
}