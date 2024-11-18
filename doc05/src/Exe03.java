/*
Exercício 3
Desafio: Reescreva este código adicionando:
Método que retorna um float chamado lerFloat.
Este método deve receber um parâmetro que será o teclado e outro parâmetro chamado mensagem que sera uma string.
O teclado sera utilizado para ler o valor e a mensagem deve ser utilizada para imprimir na tela o que o usuário deve digitar.
Método que retorna um float chamado converterParaCelcius.
Este método deve receber um float como parâmetro e devolver um float que é o valor de fahrenheit convertido para celsius.
A impressão do resultado da conversão deve ser mantida no método main.
Converter uma temperatura de fahrenheit para celcius
*/
import java.util.Scanner;
public class Exe03 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        float fahrenheit = lerFloat(teclado, "Digite a temperatura em Fahrenheit: ");
        System.out.printf("%.2f\n", converterParaCelcius(fahrenheit));
        teclado.close();
    }

    static float lerFloat (Scanner teclado, String mensagem) {
        System.out.print(mensagem);
        return teclado.nextFloat();
    }

    static float converterParaCelcius(float fahrenheit) {
        float celsius = (fahrenheit - 32) * 5 / 9;
        return celsius;
    }
}
