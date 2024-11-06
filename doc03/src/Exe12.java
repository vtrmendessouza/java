/*
Exercício 12: 
Faça um Programa que leia um número inteiro menor que 1000 
e imprima a quantidade de centenas, dezenas e unidades do mesmo. 
Observando os termos no plural a colocação do "e", da vírgula entre outros. Exemplo:
326 = 3 centenas, 2 dezenas e 6 unidades
12 = 1 dezena e 2 unidades Testar com: 326, 300, 100, 320, 310,305, 301, 101, 311, 111, 
25, 20, 10, 21, 11, 1, 7 e 16
*/
import java.util.Scanner;
public class Exe12{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        int numero = 0, centena = 0, dezena = 0, unidade = 0;

        System.out.print("Digite um número inteiro menor que 1000: ");
        numero = teclado.nextInt();
        teclado.nextLine();

        centena = numero / 100;
        dezena = (numero % 100) / 10;
        unidade = numero % 10;

        System.out.printf("%d = centenas, %d dezenas e %d unidades.", centena, dezena, unidade);

        teclado.close();
        System.exit(0);
    }
}