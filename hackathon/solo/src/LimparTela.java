import java.io.IOException;

public class LimparTela {

    static void limparTela() {

    // Verifica o sistema operacional para decidir qual comando executar
    String sistemaOperacional = System.getProperty("os.name").toLowerCase();
    
    try {
        // Se o sistema operacional for Windows
        if (sistemaOperacional.contains("win")) {
            // Executa o comando 'cls' para limpar a tela no Windows
            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            processBuilder.inheritIO().start().waitFor();
        } 
        // Se o sistema operacional for baseado em Unix (Linux, macOS)
        else {
            // Executa o comando 'clear' para limpar a tela no Linux/macOS
            ProcessBuilder processBuilder = new ProcessBuilder("clear");
            processBuilder.inheritIO().start().waitFor();
        }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace(); // Caso ocorra algum erro, imprime a exceção
        }
    }
}