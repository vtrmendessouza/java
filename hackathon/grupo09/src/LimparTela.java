//Alexandro Souza
public class LimparTela {

    public static void limparTela() {
        try {
     
            final String os = System.getProperty("os.name").toLowerCase();

            // Comando para limpar tela de acordo com o sistema operacional
            if (os.contains("windows")) {
                // Para Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para Unix-like (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
          
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
}
/*
Descrição: Utilizado para limpar a console, para que seja exibido apenas o conteúdo
atual do jogo. Dica: Pesquisa na internet por "Como limpar console no java ProcessBuilder"
Nível de complexidade: 3 de 10
*/