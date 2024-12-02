import java.util.Scanner;

import br.com.validador.validadorSenha;

public class App{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Exemplo de uso da biblioteca validadorSenha
        String senha = teclado.nextLine();
        
        try {
            boolean valida = validadorSenha.validarSenha(senha);
            System.out.println("Senha válida: " + valida);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        teclado.close();;
    }
}