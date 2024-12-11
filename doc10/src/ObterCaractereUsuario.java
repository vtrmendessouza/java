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
/*
Descrição: Utilizado para obter no início do jogo qual o caractere que o usuário quer 
utilizar para representar ele próprio. Este método recebe o teclado para permitir que o
usuário digite o caractere desejado. Faça a leitura do caractere desejado pelo usuário, 
através do teclado, realize as validações para não aceitar caracteres que não estejam
definidos pela constante CARACTERES_IDENTIFICADORES_ACEITOS, e retorne o caractere lido 
através do return.
*/