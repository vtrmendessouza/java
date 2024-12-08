import java.util.Random;
import java.util.Scanner;

public class JogoVelha {
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
        
        //TODO: Faça a inicialização do tabuleiro aqui

        // Definimos aqui qual é o caractere que cada jogador irá utilizar no jogo.
        //TODO: chame as funções obterCaractereUsuario() e obterCaractereComputador
        //para definir quais caracteres da lista de caracteres aceitos que o jogador
        //quer configurar para ele e para o computador.
        char caractereUsuario = ????;
        char caractereComputador = ????;

        // Esta variavel é utilizada para definir se o usuário começa a jogar ou não.
        // Valor true, usuario começa jogando, valor false computador começa.
        //TODO: obtenha o valor booleano sorteado
        boolean vezUsuarioJogar = ????;

        boolean jogoContinua;

        do {
            // controla se o jogo terminou
            jogoContinua = true;
            //TODO: Exiba o tabuleiro aqui

            
            if ( /*TODO: com base no bloco defina o critério */ ){
                //TODO: Execute processar vez do usuario
                tabuleiro = ?????;

                // Verifica se o usuario venceu
                //TODO: Este if deve executar apenas se teve ganhador 
                if ( /*TODO: esreva aqui a chamada para teve ganhador*/ ) {
                    //TODO: Exiba que o usuario ganhou
                    jogoContinua = false;
                }

                //TODO: defina qual o vaor a variavel abaixo deve possuir
                vezUsuarioJogar = ????;
            } else {

                //TODO: Execute processar vez do computador
                tabuleiro = ?????;

                // Verifica se o computador venceu
                //TODO: Este if deve executar apenas se teve ganhador
                if ( /*esreva aqui a chamada para teve ganhador*/ ) {

                    //TODO: Exiba que o computador ganhou
                    jogoContinua = false;
                }

                //TODO: defina qual o vaor a variavel abaixo deve possuir
                vezUsuarioJogar = ????;
            }
        
            //TODO: Este if deve executar apenas se o jogo continua E 
            //ocorreu tempate. Utilize o metodo teveEmpate()
            if ( /*escreva aqui a condicao conforme o TODO acima*/ ) {

                //TODO: Exiba que ocorreu empate
                jogoContinua = false;
            }
        } while (jogoContinua);

        teclado.close();
    }
}