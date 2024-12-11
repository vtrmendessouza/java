import java.util.Random;
import java.util.Scanner;

public class App {
    // Estes caracteres são aceitos como caracteres para representarem
    // os jogadores. Utizado para evitar caracteres que não combinem com
    // o desenho do tabuleiro.
    final static String CARACTERES_IDENTIFICADORES_ACEITOS = "XO0UC";

    // Tamanho do tabuleiro 3x3. Para o primeiro nivel de dificuldade
    // considere que este valor não será alterado.
    final static int TAMANHO_TABULEIRO = 3;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
    
        char[][] tabuleiro = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        tabuleiro = inicializarTabuleiro(tabuleiro);
    
        // Define caracteres para usuário e computador
        char caractereUsuario = obterCaractereUsuario(teclado);
        char caractereComputador = obterCaractereComputador(teclado, caractereUsuario);
    
        // Sorteia quem começa jogando
        boolean vezUsuarioJogar = sortearValorBooleano();
    
        boolean jogoContinua;
    
        do {
            limparTela();
            exibirTabuleiro(tabuleiro);
            jogoContinua = true;
    
            if (vezUsuarioJogar) {
                tabuleiro = processarVezUsuario(teclado, tabuleiro, caractereUsuario);
    
                if (teveGanhador(tabuleiro, caractereUsuario)) {
                    exibirTabuleiro(tabuleiro);
                    exibirVitoriaUsuario();
                    jogoContinua = false;
                }
                vezUsuarioJogar = false;
            } else {
                tabuleiro = processarVezComputador(tabuleiro, caractereComputador);
    
                if (teveGanhador(tabuleiro, caractereComputador)) {
                    exibirTabuleiro(tabuleiro);
                    exibirVitoriaComputador();
                    jogoContinua = false;
                }
                vezUsuarioJogar = true;
            }
    
            if (jogoContinua && teveEmpate(tabuleiro)) {
                exibirTabuleiro(tabuleiro);
                exibirEmpate();
                jogoContinua = false;
            }
        } while (jogoContinua);
    
        teclado.close();
    }
    //Inicializa o tabuleiro com o caractere ' ' (espaço).
    static char[][] inicializarTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
        return tabuleiro;
    }
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
    static char obterCaractereComputador(Scanner teclado, char caractereUsuario) {
        
        char caractereComputador;
        while (true) {
            System.out.print("Digite o caractere para o computador (X, O, 0, U, C): ");
            caractereComputador = teclado.next().toUpperCase().charAt(0);

            // Verifica se o caractere está na lista aceita e é diferente do caractere do usuário
            if (CARACTERES_IDENTIFICADORES_ACEITOS.indexOf(caractereComputador) != -1 && caractereComputador != caractereUsuario) {
                break; // Sai do loop se for válido
            } else {
                System.out.println("Caractere inválido ou já escolhido pelo usuário. Tente novamente.");
            }
        }
        return caractereComputador;
    }
    static boolean jogadaValida(String posicoesLivres, int linha, int coluna) {
        // Formata a jogada no formato "linha,coluna"
        String jogada = linha + "," + coluna;

        // Verifica se a jogada está presente na string de posições livres
        return posicoesLivres.contains(jogada);
    }

    static int[] obterJogadaUsuario(String posicoesLivres, Scanner teclado) {
        int[] jogada = new int[2];
        boolean jogadaAceita = false;

        while (!jogadaAceita) {
            try {
                // Exibe o prompt apenas uma vez por iteração
                System.out.print("Digite a linha e coluna com espaço entre eles: ");
                String entrada = teclado.nextLine().trim();

                // Se a entrada for vazia, continue sem exibir mensagens adicionais
                if (entrada.isEmpty()) {
                    continue;
                }

                String[] partes = entrada.split(" ");

                // Verifica se foram fornecidos dois números
                if (partes.length != 2) {
                    System.out.println("Entrada inválida! Digite dois números separados por espaço.");
                    continue;
                }

                // Tenta converter os números
                int linha = Integer.parseInt(partes[0]);
                int coluna = Integer.parseInt(partes[1]);

                // Valida se a jogada está nas posições livres
                if (jogadaValida(posicoesLivres, linha, coluna)) {
                    jogada[0] = linha;
                    jogada[1] = coluna;
                    jogadaAceita = true;
                } else {
                    System.out.println("Jogada não existe ou está indisponível. Tente novamente!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Certifique-se de digitar números válidos.");
            }
        }
        return jogada;
    }


    


    static int[] obterJogadaComputador(String posicoesLivres) {
        String[] vetorPosicoes = posicoesLivres.split(";");
        Random random = new Random();

        // Sorteia uma posição livre
        int indiceSorteado = random.nextInt(vetorPosicoes.length);

        // Converte a posição sorteada para um vetor de inteiros
        return converterJogadaStringParaVetorInt(vetorPosicoes[indiceSorteado]);
    }

    static int[] converterJogadaStringParaVetorInt(String jogada) {
        // Divide a string no formato "linha,coluna" usando vírgula como separador
        String[] partes = jogada.split(",");

        // Inicializa o vetor de inteiros para linha e coluna
        int[] jogadaVetor = new int[2];
        jogadaVetor[0] = Integer.parseInt(partes[0]); // Linha
        jogadaVetor[1] = Integer.parseInt(partes[1]); // Coluna

        return jogadaVetor;
    }

    static char[][] processarVezUsuario(Scanner teclado, char[][] tabuleiro, char caractereUsuario) {
        System.out.println("\nVez do usuário: ");
        String posicoesLivres = retornarPosicoesLivres(tabuleiro);
        int[] jogada = obterJogadaUsuario(posicoesLivres, teclado);
        tabuleiro = retornarTabuleiroAtualizado(tabuleiro, jogada, caractereUsuario);
        return tabuleiro;
    }

    static char[][] processarVezComputador(char[][] tabuleiro, char caractereComputador) {
        System.out.println("\nVez do computador: ");
        String posicoesLivres = retornarPosicoesLivres(tabuleiro);
        int[] jogada = obterJogadaComputador(posicoesLivres);
        tabuleiro = retornarTabuleiroAtualizado(tabuleiro, jogada, caractereComputador);
        return tabuleiro;
    }

    static String retornarPosicoesLivres(char[][] tabuleiro) {
        StringBuilder posicoesLivres = new StringBuilder();

        // Percorre as linhas e colunas do tabuleiro
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                // Verifica se a posição está livre (representada por um espaço)
                if (tabuleiro[i][j] == ' ') {
                    // Adiciona a posição no formato "linha,coluna" ao resultado
                    posicoesLivres.append(i).append(",").append(j).append(";");
                }
            }
        }

        // Remove o último ";" caso exista
        if (posicoesLivres.length() > 0) {
            posicoesLivres.setLength(posicoesLivres.length() - 1);
        }
        return posicoesLivres.toString();
    }

    // Verifica se o jogador ganhou em alguma linha, coluna, diagonal peincipal ou secundária
    static boolean teveGanhador(char[][] tabuleiro, char caractereJogador) {
        if (teveGanhadorLinha(tabuleiro, caractereJogador)) {
            return true;
        }
        if (teveGanhadorColuna(tabuleiro, caractereJogador)) {
            return true;
        }
        if (teveGanhadorDiagonalPrincipal(tabuleiro, caractereJogador)) {
            return true;
        }
        if (teveGanhadorDiagonalSecundaria(tabuleiro, caractereJogador)) {
            return true;
        }
        return false;
    }
    // Verifica se toda a linha está preenchida com o caractere do jogador
    static boolean teveGanhadorLinha(char[][] tabuleiro, char caractereJogador) {
        for (int i = 0; i < tabuleiro.length; i++) { 
            boolean venceu = true;
            for (int j = 0; j < tabuleiro[i].length; j++) { 
                if (tabuleiro[i][j] != caractereJogador) {
                    venceu = false;
                    break;
                }
            }
            if (venceu) {
                return true; 
            }
        }
        return false; 
    }

    // Verifica se toda a coluna está preenchida com o caractere do jogador
    static boolean teveGanhadorColuna(char[][] tabuleiro, char caractereJogador) {
        for (int j = 0; j < tabuleiro.length; j++) { // Percorre todas as colunas
            boolean venceu = true;
            for (int i = 0; i < tabuleiro.length; i++) { // Verifica cada linha da coluna
                if (tabuleiro[i][j] != caractereJogador) {
                    venceu = false;
                    break;
                }
            }
            if (venceu) {
                return true; // Retorna true se todas as linhas da coluna forem do jogador
            }
        }
        return false; 
    }

    // Verifica se a diagonal principal está toda preenchida com o caractere do jogador
    static boolean teveGanhadorDiagonalPrincipal(char[][] tabuleiro, char caractereJogador) {
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][i] != caractereJogador) {
                return false;
            }
        }
        return true;
    }
    // Verifica se a diagonal secundária está toda preenchida com o caractere do jogador
    static boolean teveGanhadorDiagonalSecundaria(char[][] tabuleiro, char caractereJogador) {
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][tabuleiro.length - 1 - i] != caractereJogador) {
                return false;
            }
        }
        return true;
    }
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
    static void exibirTabuleiro(char[][] tabuleiro) {
        System.out.println("   0   1   2");
        for (int l = 0; l < 3; l++) {
            System.out.print(l + " ");
            for (int c = 0; c < 3; c++) {
                System.out.print(" " + tabuleiro[l][c] + " ");
                if (c < 2) System.out.print("|");
            }
            if (l < 2) System.out.println("\n  -----------");
        }
    }
    static char[][] retornarTabuleiroAtualizado(char[][] tabuleiro, int[] jogada, char caractereJogador) {
        
        tabuleiro[jogada[0]][jogada[1]] = caractereJogador;
        return tabuleiro;
    }    
    static void exibirVitoriaComputador() {

        System.out.println("\nO computador venceu!");
        System.out.println("""
        \t\t\t    +---------------+
        \t\t\t    | +-----------+ |
        \t\t\t    | | __    __  | |
        \t\t\t    | |  0    0   | |
        \t\t\t    | |    --     | |
        \t\t\t    | |   \\__/   | |
        \t\t\t    | |           | |
        \t\t\t    | +-----------+ |
        \t\t\t    +-----+---+-----+
        \t\t\t    ______|   |_____
        \t\t\t   /                \\
        \t\t\t  /  --------------- \\
        \t\t\t /   ---------------  \\
        \t\t\t +--------------------+
        \n\n""");
    }
    static void exibirVitoriaUsuario() {
      
        System.out.println("\nO usuário Venceu!");
        System.out.println("""
        \t\t\t          /////////
        \t\t\t    \\\\|/////////
        \t\t\t     \\/////////
        \t\t\t     |         |
        \t\t\t    (| --- --- |)
        \t\t\t     |  0   0  |
        \t\t\t     |    ..   |
        \t\t\t     |  \\___/  |
        \t\t\t     |_________|
        \t\t\t        |   |
        \t\t\t        |   |
        \t\t\t       /     \\
        \t\t\t      /       \\
        \n\n\n""");
    }
    static void exibirEmpate() {
        System.out.println("Ocorreu empate!");
        System.out.println("+---+       +---+");
        System.out.println("| 0 |   X   | 0 |");
        System.out.println("+---+       +---+");
    }
    // Percorre todo o tabuleiro e verifica se há algum espaço vazio
    static boolean teveEmpate(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean sortearValorBooleano() {
        Random random = new Random();
        return random.nextBoolean();
    }
}