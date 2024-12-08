import java.util.Scanner;

public class ObterJogadaUsuario {

    static int[] obterJogadaUsuario(String posicoesLivres, Scanner teclado, int tamanhoTabuleiro) {

        // Vetor para armazenar linha e coluna
        int[] jogada = new int[2];
        boolean jogadaValida = false;
    
        while (!jogadaValida) {
            try {
                // Mensagem pedindo a jogada do usuário
                System.out.println("Digite a linha e a coluna que deseja jogar separados por um espaço. (Exemplo: 1 2):");
                String entrada = teclado.nextLine().trim();
    
                // Dividir a entrada em dois valores separados por espaço
                String[] valores = entrada.split(" ");
    
                // Verificar se foram digitados exatamente dois valores
                if (valores.length != 2) {
                    System.out.println("Digite dois números separados por espaço.");
                    continue;
                }
                // Converter os valores para números inteiros
                int linha = Integer.parseInt(valores[0]);
                int coluna = Integer.parseInt(valores[1]);
    
                // Ajustar os valores para índices (de 1-n para 0-n-1)
                linha -= 1;
                coluna -= 1;
    
                // Verificar se a jogada está dentro dos limites do tabuleiro
                if (linha < 0 || linha >= tamanhoTabuleiro || coluna < 0 || coluna >= tamanhoTabuleiro) {
                    System.out.println("Linha ou coluna fora dos limites.");
                    continue;
                }
                // Verificar se a jogada está presente na lista de posições livres
                String jogadaFormatada = linha + "" + coluna;
                if (!posicoesLivres.contains(jogadaFormatada)) {
                    System.out.println("Esta jogada não é permitida.");
                    continue;
                }
                // A jogada é válida
                jogada[0] = linha;
                jogada[1] = coluna;
                jogadaValida = true;
    
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
            }
        }
        return jogada;
    }
}