import java.util.Scanner;
import br.com.producao.ValidadorCpf;
public class TesteCpf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cpf = scanner.nextLine();

        try {
            boolean valida = ValidadorCpf.validarCpf(cpf);
            System.out.println("CPF válido: " + valida);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        scanner.close();
    }
}