import java.util.Scanner;

public class ObterJogadaUsuario {

    static int[] obterJogadaUsuario(String posicoesLivres, Scanner teclado) {

        int[] jogada = new int[2]; // Vetor para armazenar linha e coluna
        boolean jogadaValida = false;
    
        while (!jogadaValida) {
            try {
                System.out.println("Digite a linha e a coluna que deseja jogar, separados por um espaço (Exemplo: 1 2):");
                String entrada = teclado.nextLine().trim();
    
                // Dividir a entrada em dois valores separados por espaço
                String[] valores = entrada.split(" ");
    
                // Verificar se foram digitados exatamente dois valores
                if (valores.length != 2) {
                    System.out.println("Por favor, digite dois números separados por espaço!");
                    continue;
                }
                // Converter os valores para números inteiros
                int linha = Integer.parseInt(valores[0]);
                int coluna = Integer.parseInt(valores[1]);
    
                // Ajustar os valores para índices (de 1-3 para 0-2)
                linha -= 1;
                coluna -= 1;
    
                // Verificar se a jogada está dentro dos limites do tabuleiro (3x3)
                if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
                    System.out.println("Linha ou coluna fora dos limites! Digite valores entre 1 e 3.");
                    continue;
                }
    
                // Verificar se a jogada está presente na lista de posições livres
                String jogadaFormatada = linha + "" + coluna;
                if (!posicoesLivres.contains(jogadaFormatada)) {
                    System.out.println("Esta jogada não é permitida, escolha outra posição!");
                    continue;
                }
    
                // A jogada é válida
                jogada[0] = linha;
                jogada[1] = coluna;
                jogadaValida = true;
    
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Certifique-se de digitar dois números inteiros.");
            }
        }
        return jogada;
    }
}