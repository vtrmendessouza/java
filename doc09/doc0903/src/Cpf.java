import java.util.Scanner;
import br.com.producao.ValidadorCpf;
public class Cpf {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String cpf = teclado.nextLine();

        try {
            boolean valida = ValidadorCpf.validarCpf(cpf);
            System.out.println("CPF válido: " + valida);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        teclado.close();
    }
}