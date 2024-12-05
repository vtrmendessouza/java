import java.util.Scanner;
import br.com.producao.ValidadorSenha;
public class TesteSenha {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String senha = teclado.nextLine();

        try {
            boolean valida = ValidadorSenha.validarSenha(senha);
            System.out.println("Senha válida: " + valida);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        teclado.close();
    }
}