/*
Desafio: Reescreva este código adicionando:
Método que retorna um int chamado lerInt. Este método deve receber um parâmetro que será o teclado e outro parâmetro chamado mensagem que sera uma string.
O teclado serautilizado para ler o valor e a mensagem deve ser utilizada para imprimir na tela o que o usuário deve digitar.
Método que retorna um valor boolean chamado ehImpar. Este método deve receber um parâmetro e analisar se este valor e um número ímpar.
Se for um numero ímpar retorne true,se for par retorne false.
Método que imprime na tela se o número é par ou ímpar chamado mostrarResultado. Este método deve receber dois parâmetros. 
O primeiro parâmetro deve ser o número a ser impresso o segundo parâmetro e se o valor e ímpar . 
3-Faça um algoritmo para receber um número qualquer e 
informar na tela se é par ou ímpar.
*/
import java.util.Scanner;
public class Exe00 {
    public static void main (String[] args) throws Exception {
        
        int valor = 0;
        Scanner teclado = new Scanner(System.in);
        
        valor = lerInt(teclado, "Digite um número inteiro: ");
        imprimeResultado(valor, ehImpar(valor));
        teclado.close();
    }
    static int lerInt (Scanner teclado, String mensagem) {
        System.out.print(mensagem);
        return teclado.nextInt();
    }
    static boolean ehImpar (int valor) {
        return valor % 2 != 0;
    }
    static void imprimeResultado (int valor, boolean ehImpar) {
        if (ehImpar) {
            System.out.println("O número " + valor + " é ímpar.");
        } else {
            System.out.println("O número " + valor + " é par.");
        }
    }
}