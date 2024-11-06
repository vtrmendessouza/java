/*
Exercício 14: 
Faça um Programa que leia três números e mostre o maior e o menor deles.
*/
import java.util.Scanner;
public class Exe14{
	public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        int primeiro = 0, segundo = 0, terceiro = 0, maior = 0, menor = 0;

        System.out.print("Digite o primeiro número: ");
        primeiro = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Digite o segundo número: ");
        segundo = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Digite o terceiro número: ");
        terceiro = teclado.nextInt();
        teclado.nextLine();

        if(primeiro > terceiro && terceiro > segundo){
            maior = primeiro;
            menor = segundo;
            System.out.printf("Maior: %d\nMenor: %d", maior, menor);
        }
        else if(primeiro > segundo && segundo > terceiro){
            maior = primeiro;
            menor = terceiro;
            System.out.printf("Maior: %d\nMenor: %d", maior, menor);
        }
        else if(segundo > terceiro && terceiro > primeiro){
            maior = segundo;
            menor = primeiro;
            System.out.printf("Maior: %d\nMenor: %d", maior, menor);
        }
        else if(segundo > primeiro && primeiro > terceiro){
            maior = segundo;
            menor = terceiro;
            System.out.printf("Maior: %d\nMenor: %d", maior, menor);
        }
        else if(terceiro > segundo && segundo > primeiro){
            maior = terceiro;
            menor = primeiro;
            System.out.printf("Maior: %d\nMenor: %d", maior, menor);
        }
        else if(terceiro > primeiro && primeiro > segundo){
            maior = terceiro;
            menor = segundo;
            System.out.printf("Maior: %d\nMenor: %d", maior, menor);
        }
        else{
            System.out.print("Um ou mais números sâo iguais");
        }
        teclado.close();
        System.exit(0);
    }
}