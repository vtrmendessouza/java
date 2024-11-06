/*
Faça um algoritmo que leia dois valores inteiros A e B 
se os valores forem iguais deverá se somar os dois, 
caso contrário multiplique A por B. 
Ao final de qualquer um dos cálculos deve-se 
atribuir o resultado para uma variável C e mostrar seu conteúdo na tela.
*/
import java.util.Scanner;
public class Exe04{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        int a = 0, b = 0, c = 0;
        
        System.out.print("Atribua um valor inteiro para A: ");
        a = teclado.nextInt();
        
        System.out.print("Atribua um valor inteiro para B: ");
        b = teclado.nextInt();
        
        if(a == b){
            c = a + b;
            System.out.printf("O valor de C é: %d", c);
            }
        else{
            c = a * b;
            System.out.printf("O valor de C é: %d", c);
            }
        teclado.close();
    }
}