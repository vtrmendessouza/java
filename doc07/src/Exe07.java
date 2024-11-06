/*
07: Faça um algoritmo que lê vários valores inteiros. 
Após a leitura de um valor o usuário responde se deseja digitar um novo valor. 
Após a leitura dos valores apresente a média dos valores pares e a média dos valores ímpares.
*/
import java.util.Scanner;

public class Exe07 {
        public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        int numero = 0, positivo = 0, negativo = 0, somaPositivo = 0, somaNegativo = 0;
        char resposta = 's';
        
        while(resposta == 's'){
            System.out.printf("Digite um número inteiro: ");
            numero = teclado.nextInt();
            if(numero > 0){
                positivo ++;
                somaPositivo += numero;
            }
            else if (numero < 0){
                negativo ++;
                somaNegativo += numero;
            }
            System.out.printf("Deseja continuar? s/n: ");
            resposta = teclado.next().charAt(0);
        }
        System.out.printf("Média dos números positivos: %d\n", somaPositivo / positivo);
        System.out.printf("Média dos números negativos: %d\n", somaNegativo / negativo);
        teclado.close();
    }    
}