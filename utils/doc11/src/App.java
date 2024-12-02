import br.com.validador.validadorSenha;

public class App{
    public static void main(String[] args) {
        // Exemplo de uso da biblioteca validadorSenha
        String senha = "Senha123!";
        
        try {
            boolean valida = validadorSenha.validarSenha(senha);
            System.out.println("Senha válida: " + valida);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}