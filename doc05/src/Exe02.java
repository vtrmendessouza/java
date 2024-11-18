/*
Exercício 2
Desafio: Reescreva este código adicionando:
Método que retorna um float chamado lerFloat. 
Este método deve receber um parâmetro que será o teclado e outro parâmetro chamado mensagem que sera uma string.
O teclado sera utilizado para ler o valor e a mensagem deve ser utilizada para imprimir na tela o que o usuário deve digitar.
Método que retorna um float chamado converterReaisParaDolares.
Este método deve receber um float como parâmetro e devolver um float que é o valor de reais convertido para dólares.
A impressão do resultado da conversão deve ser mantida no método main.
Converter uma valor em reais para dollar
*/
import java.util.Scanner;
public class Exe02 {
    public static void main(String[] args) {
        
        float real = 0, dolar = 0, cotacao = 0.19f;
        Scanner teclado = new Scanner(System.in);
        
        real = lerFloat(teclado, "Digite o valor em Reais: ");
        imprimeResultado(converterReaisParaDolares(real, dolar, cotacao));
        teclado.close();
    }
 
    static float lerFloat(Scanner teclado, String mensagem) {
        System.out.print(mensagem);
        return teclado.nextFloat();
    }

    static float converterReaisParaDolares(float real, float dolar, float cotacao) {
        dolar = real * cotacao;
        return dolar;
    }

    static void imprimeResultado(float dolar) {
        System.out.printf("Valor em Dólares: %.2f\n", dolar);
    }
}