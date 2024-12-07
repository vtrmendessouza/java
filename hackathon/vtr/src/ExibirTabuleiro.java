import java.util.Scanner;

public class ExibirTabuleiro {
    
    // Tamanho fixo do tabuleiro 3x3
    private static final int TAMANHO_TABULEIRO = 3;

    public static void exibirTabuleiro(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Inicializa o tabuleiro com o tamanho fixo 3x3
        char[][] tabuleiro = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        inicializarTabuleiro(tabuleiro);
        
        // Obtém os caracteres para o jogador e computador
        char caractereUsuario = obterCaractereUsuario(teclado);
        char caractereComputador = obterCaractereComputador(teclado, caractereUsuario);
        
        System.out.println("Caractere do usuário: " + caractereUsuario);
        System.out.println("Caractere do computador: " + caractereComputador);
    }

//EXTRA*****************************************
    private static char obterCaractereComputador(Scanner teclado, char caractereUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterCaractereComputador'");
    }

    private static char obterCaractereUsuario(Scanner teclado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterCaractereUsuario'");
    }

    private static void inicializarTabuleiro(char[][] tabuleiro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inicializarTabuleiro'");
    }
}