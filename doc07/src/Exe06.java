/*
06: Faça um algoritmo que lê 5 valores inteiros, um de cada vez, 
e conte quantos destes valores são negativos e quantos são positivos, 
no fim escreva na tela a quantidade de números positivos e negativos lidos.
*/

import java.util.Scanner;

public class Exe06 {
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        int numero = 0, positivo = 0, negativo = 0;

        for(int i = 0; i < 5; i++){
            System.out.printf("Digite um número inteiro: ");
            numero = teclado.nextInt();
            if(numero > 0){
                positivo ++;
            }
            else if (numero < 0){
                negativo ++;
            }
        }
        System.out.printf("Quantidade de números positivos: %d\n", positivo);
        System.out.printf("Quantidade de números negativos: %d\n", negativo);
        teclado.close();
    }    
}