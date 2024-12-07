import java.util.Scanner;

public class ObterJogada {

    static int[] obterJogadaerJogadaUsuario(String posicoesLivres, Scanner teclado) {
        int[] jogada = new int[2];
        boolean jogadaAceita = false;

        while (!jogadaAceita) {

            try {
                System.out.println("Digite a linha e coluna com espaço entre eles");
                String entrada = teclado.nextLine();
                String[] partes = entrada.trim().split(" ");

                if (partes.length != 2) {
                    System.out.println("Entrada invalida! digite dois numeros entre espaço");
                    continue;
                }
                int linha = Integer.parseInt(partes[0]);
                int coluna = Integer.parseInt(partes[1]);

                if (linha > 0 && coluna > 0 && jogadaValida(posicoesLivres, linha, coluna)) {
                    jogada[0] = linha;
                    jogada[1] = coluna;
                    jogadaAceita = true;
                } else {
                    System.out.println("Jogada nao existe ou está indisponivel. Tente novameente!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada nao valida! digite numeros válidos!");
            }
        }
        return jogada;
    }
}