/*
Exercício 08: 
Faça um Programa que peça os 3 lados de um triângulo. 
O programa deverá informar se os valores podem ser um triângulo. 
Indique, caso os lados formem um triângulo, se o mesmo é: equilátero, isósceles ou escaleno. Dicas:
Três lados formam um triângulo quando a soma de quaisquer dois lados for maior que o terceiro;
Triângulo Equilátero: três lados iguais;
Triângulo Isósceles: quaisquer dois lados iguais;
Triângulo Escaleno: três lados diferentes;
*/
import java.util.Scanner;
public class Exe08{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        float lado1, lado2, lado3;
        
        System.out.print("Informe três valores\n");
        System.out.print("Primeiro valor: ");
        lado1 = teclado.nextFloat();
        teclado.nextLine();
        System.out.print("Segundo valor: ");
        lado2 = teclado.nextFloat();
        teclado.nextLine();
        System.out.print("Terceiro valor: ");
        lado3 = teclado.nextFloat();
        teclado.nextLine();

        if (lado1 == lado2 && lado1 == lado3) {
            System.out.print("Triângulo Equilátero.");
        }
        else if (lado1 == lado2 && lado1 != lado3) {
            System.out.print("Triângulo Isóceles.");
        }
        else if (lado1 == lado3 && lado1 != lado2) {
            System.out.print("Triângulo Isóceles.");
        }
        else if (lado2 == lado3 && lado2 != lado1) {
            System.out.print("Triângulo Isóceles.");
        }
        else {
            System.out.print("Triângulo Escaleno.");
        }
        teclado.close();
        System.exit(0);
    }
}