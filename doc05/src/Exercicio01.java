/*
Exercício 1
Desafio: Reescreva este código adicionando:
Método que retorna um int chamado lerInt.
Este método deve receber um parâmetro que será o teclado e outro parâmetro chamado mensagem que sera uma string.
O teclado sera utilizado para ler o valor e a mensagem deve ser utilizada para imprimir na tela o que o usuário deve digitar.
Método que imprime na tela se a + b é maior que c, chamado mostrarResultado.
Este método deve receber três parâmetros. Os parâmetros devem ser o valor de a, de b e de c.
*/
import java.util.Scanner;
public class Exercicio01 {
    public static void main (String[] args) throws Exception {
        
        int a = 0, b = 0, c = 0;
        Scanner teclado = new Scanner(System.in);
        
        a = lerInt(teclado, "Digite o primeiro valor inteiro: ");
        b = lerInt(teclado, "Digite o segundo valor inteiro: ");
        c = lerInt(teclado, "Digite o terceiro valor inteiro: ");
        imprimeResultado(a, b, c);

        teclado.close();
    }

    static int lerInt (Scanner teclado, String mensagem) {
        System.out.print(mensagem);
        return teclado.nextInt();
    }

    static void imprimeResultado (int a, int b, int c) {
        if (a + b > c) {
            System.out.println("A soma de A + B é maior C");
        } else {
            System.out.println("A soma de A + B não é maior C");
        }
    }
}