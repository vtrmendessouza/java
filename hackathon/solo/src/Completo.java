import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Completo {
    
    //Inicializa o tabuleiro 3x3 com o caractere ' ' (espaço).
    //@param tabuleiro = Matriz de caracteres representando o tabuleiro.
    //@return O = tabuleiro inicializado.
    static char[][] inicializarTabuleiro(char[][] tabuleiro) {
        // Percorre todas as linhas e colunas do tabuleiro
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                // Define cada posição com o caractere ' ' (espaço)
                tabuleiro[i][j] = ' ';
            }
        }
        // Retorna o tabuleiro inicializado
        return tabuleiro;
    }
    // Constante com os caracteres aceitos
    private static final char[] CARACTERES_IDENTIFICADORES_ACEITOS = {'X', 'O', 'A', 'B', 'C'};

    //Solicita ao usuário um caractere para representá-lo no jogo.
    //@param teclado = Objeto Scanner para entrada de dados pelo teclado.
    //@return O = caractere escolhido pelo usuário.
   
    static char obterCaractereUsuario(Scanner teclado) {
        char caractereEscolhido;
        boolean caractereValido = false;

        do {
            // Solicita ao usuário para escolher um caractere
            System.out.print("Escolha um caractere para representar você (X, O, A, B, C): ");
            String entrada = teclado.nextLine();

            // Valida se o usuário digitou apenas um caractere
            if (entrada.length() == 1) {
                caractereEscolhido = entrada.charAt(0);

                // Verifica se o caractere está na lista de permitidos
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
                caractereEscolhido = ' '; // Apenas inicializa para evitar erro de compilação
            }
        } while (!caractereValido); // Continua até que o caractere seja válido

        return caractereEscolhido;
    }
    // Constante com os caracteres aceitos
    //private static final char[] CARACTERES_IDENTIFICADORES_ACEITOS = {'X', 'O', 'A', 'B', 'C'};

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
    //Verifica se a jogada do usuário é válida, ou seja, se está presente na lista de posições livres.
    //@param posicoesLivres = String contendo as posições livres no formato "xy;xy;..."
    //@param linha = Linha escolhida pelo jogador.
    //@param coluna = Coluna escolhida pelo jogador.
    //@return true se a jogada for válida, false caso contrário.
 
    static boolean jogadaValida(String posicoesLivres, int linha, int coluna) {
        // Constrói a representação da posição no formato "xy"
        String posicaoJogada = linha + "" + coluna;

        // Verifica se a posição está contida na string de posições livres
        return posicoesLivres.contains(posicaoJogada);
    }
    //Obtém a jogada do computador sorteando uma posição livre.
    //@param posicoesLivres = String com as posições livres no formato "xy;xy;..."
    //@param teclado = Objeto Scanner (não utilizado, mas incluído na assinatura).
    //@return Vetor de inteiros contendo [linha, coluna] no formato de índice.
 
    static int[] obterJogadaComputador(String posicoesLivres, Scanner teclado) {

        // Divide as posições livres em um vetor de strings
        String[] vetorPosicoesLivres = posicoesLivres.split(";");

        // Gera um número aleatório dentro do intervalo de posições livres
        Random random = new Random();
        int indiceSorteado = random.nextInt(vetorPosicoesLivres.length);

        // Obtém a posição sorteada no formato "xy"
        String jogadaSorteada = vetorPosicoesLivres[indiceSorteado];

        // Converte a jogada no formato "xy" para um vetor de inteiros [x, y]
        return converterJogadaStringParaVetorInt(jogadaSorteada);
    }
    //Converte uma jogada no formato "xy" para um vetor de inteiros [x, y].
    //@param jogada String no formato "xy", onde x representa a linha e y representa a coluna.
    //@return Vetor de inteiros contendo [linha, coluna].

    static int[] converterJogadaStringParaVetorInt(String jogada) {

        // Extrai o caractere referente à linha (x) e converte para inteiro
        int linha = Character.getNumericValue(jogada.charAt(0));

        // Extrai o caractere referente à coluna (y) e converte para inteiro
        int coluna = Character.getNumericValue(jogada.charAt(1));

        // Retorna o vetor de inteiros [linha, coluna]
        return new int[] { linha, coluna };
    }
    //Realiza as ações necessárias para processar a vez do usuário jogar.
    //@param teclado O scanner usado para obter entradas do usuário.
    //@param tabuleiro O tabuleiro atual do jogo.
    //@param caractereUsuario O caractere utilizado pelo usuário.
    //@return O tabuleiro atualizado após a jogada do usuário.

    static char[][] processarVezUsuario(Scanner teclado, char[][] tabuleiro, char caractereUsuario) {
        // Exibe mensagem indicando que é a vez do usuário
        System.out.println("É a sua vez, usuário! Faça sua jogada.");

        // Obtém a jogada do usuário
        int[] jogada = obterJogadaUsuario(retornarPosicoesLivres(tabuleiro), teclado);

        // Atualiza o tabuleiro com a jogada do usuário
        tabuleiro = retornarTabuleiroAtualizado(tabuleiro, jogada, caractereUsuario);

        // Retorna o tabuleiro atualizado
        return tabuleiro;
    }
    static char[][] processarVezComputador(char[][] tabuleiro, char caractereComputador) {
        System.out.println("É a vez do computador!");
        
        // Obter as posições livres no tabuleiro
        String posicoesLivres = retornarPosicoesLivres(tabuleiro);

        // Obter a jogada do computador a partir das posições livres
        int[] jogadaComputador = obterJogadaComputador(posicoesLivres);

        // Atualizar o tabuleiro com a jogada do computador
        return retornarTabuleiroAtualizado(tabuleiro, jogadaComputador, caractereComputador);
    }

    static String retornarPosicoesLivres(char[][] tabuleiro) {
        StringBuilder posicoesLivres = new StringBuilder();  // Usando StringBuilder para construir a string
        
        // Percorrer o tabuleiro para encontrar as posições livres
        for (int i = 0; i < tabuleiro.length; i++) {  // Percorre as linhas
            for (int j = 0; j < tabuleiro[i].length; j++) {  // Percorre as colunas
                // Se a posição estiver livre (caractere ' '), adiciona à lista de posições livres
                if (tabuleiro[i][j] == ' ') {
                    posicoesLivres.append(i).append(j).append(";");  // Adiciona a posição no formato xy
                }
            }
        }
        // Se a lista de posições livres não estiver vazia, remove o último ponto e vírgula
        if (posicoesLivres.length() > 0) {
            posicoesLivres.deleteCharAt(posicoesLivres.length() - 1);
        }
        // Retorna a string com as posições livres
        return posicoesLivres.toString();
    }
    static boolean teveGanhador(char[][] tabuleiro, char caractereJogador) {

        // Verifica se o jogador ganhou em alguma linha
        if (teveGanhadorLinha(tabuleiro, caractereJogador)) {
            return true;
        }
        // Verifica se o jogador ganhou em alguma coluna
        if (teveGanhadorColuna(tabuleiro, caractereJogador)) {
            return true;
        }
        // Verifica se o jogador ganhou na diagonal principal
        if (teveGanhadorDiagonalPrincipal(tabuleiro, caractereJogador)) {
            return true;
        }
        // Verifica se o jogador ganhou na diagonal secundária
        if (teveGanhadorDiagonalSecundaria(tabuleiro, caractereJogador)) {
            return true;
        }
        // Se não encontrou ganhador, retorna false
            return false;
    }
    // Verifica se o jogador ganhou em alguma linha
    static boolean teveGanhadorLinha(char[][] tabuleiro, char caractereJogador) {
        // Verifica se todas as células de uma linha estão preenchidas com o caractere do jogador
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == caractereJogador && 
                tabuleiro[i][1] == caractereJogador && 
                tabuleiro[i][2] == caractereJogador) {
                return true;  // Ganhou na linha
            }
        }
        return false;  // Não ganhou em nenhuma linha
    }
    // Verifica se o jogador ganhou em alguma coluna
    static boolean teveGanhadorColuna(char[][] tabuleiro, char caractereJogador) {
        // Verifica se todas as células de uma coluna estão preenchidas com o caractere do jogador
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == caractereJogador && 
                tabuleiro[1][j] == caractereJogador && 
                tabuleiro[2][j] == caractereJogador) {
                return true;  // Ganhou na coluna
            }
        }
        return false;  // Não ganhou em nenhuma coluna
    }
    // Verifica se o jogador ganhou na diagonal principal
    static boolean teveGanhadorDiagonalPrincipal(char[][] tabuleiro, char caractereJogador) {
        // Verifica se a diagonal principal está toda preenchida com o caractere do jogador
        return tabuleiro[0][0] == caractereJogador && 
            tabuleiro[1][1] == caractereJogador && 
            tabuleiro[2][2] == caractereJogador;
    }
    // Verifica se o jogador ganhou na diagonal secundária
    static boolean teveGanhadorDiagonalSecundaria(char[][] tabuleiro, char caractereJogador) {
        // Verifica se a diagonal secundária está toda preenchida com o caractere do jogador
        return tabuleiro[0][2] == caractereJogador && 
            tabuleiro[1][1] == caractereJogador && 
            tabuleiro[2][0] == caractereJogador;
    }
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
    static void exibirTabuleiro(char[][] tabuleiro) {
        // Limpa a tela antes de exibir o tabuleiro
        limparTela();
    
        // Exibe o conteúdo do tabuleiro no formato de uma grade 3x3
        System.out.println("Tabuleiro:");
        
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < tabuleiro[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < tabuleiro.length - 1) {
                System.out.println("---------");
            }
        }
    }
    static char[][] retornarTabuleiroAtualizado(char[][] tabuleiro, int[] jogada, char caractereJogador) {

        // Atualiza o tabuleiro na posição indicada pela jogada
        tabuleiro[jogada[0]][jogada[1]] = caractereJogador;
    
        // Retorna o tabuleiro atualizado
        return tabuleiro;
    }
    static void exibirVitoriaComputador() {

        // Exibe a mensagem de vitória do computador
        System.out.println("O computador venceu!");
    
        // Exibe a arte ASCII do computador feliz
        System.out.println("      _____     ");
        System.out.println("     |     |    ");
        System.out.println("     |     |    ");
        System.out.println("     | O O |    ");
        System.out.println("     |  ^  |    ");
        System.out.println("     | '-' |    ");
        System.out.println("     |_____|    ");
        System.out.println("     /     \\   ");
        System.out.println("    |       |   ");
        System.out.println("    |_______|   ");
    }
    static void exibirVitoriaUsuario() {

        // Exibe a mensagem de vitória do usuário
        System.out.println("O usuário venceu!");
    
        // Exibe a arte ASCII do usuário feliz
        System.out.println("      _____     ");
        System.out.println("     /     \\    ");
        System.out.println("    |  O O  |   ");
        System.out.println("    |   ^   |   ");
        System.out.println("    |  \\_/  |   ");
        System.out.println("     \\_____/    ");
        System.out.println("       | |      ");
        System.out.println("      /   \\     ");
    }
    static void exibirEmpate() {

        // Exibe a mensagem de empate
        System.out.println("Ocorreu empate!");
    
        // Exibe a arte ASCII do placar "0 X 0"
        System.out.println("    _____   _____ ");
        System.out.println("   |     | |     |");
        System.out.println("   |  0  | |  X  |");
        System.out.println("   |_____| |_____|");
    }
    static boolean teveEmpate(char[][] tabuleiro) {

        // Percorrer todo o tabuleiro e verificar se há algum espaço vazio
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == ' ') {
                    // Se encontrar algum espaço vazio, significa que o jogo não terminou em empate
                    return false;
                }
            }
        }
        // Se não encontrar espaços vazios, então o jogo terminou em empate
        return true;
    }
    public class SortearValorBooleano {

        static boolean sortearValorBooleano() {
    
            // Criar um objeto Random
            Random random = new Random();
        
            // Retornar o valor sorteado (true ou false)
            return random.nextBoolean();
        }
    }
}