/*
Escreva um algoritmo que leia três valores inteiros e diferentes 
e mostre-os em ordem decrescente.
*/
import java.util.Scanner;
public class Exe08{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        int a = 0, b = 0, c = 0;
        
        System.out.print("Escolha um número inteiro: ");
        a = teclado.nextInt();
        
        System.out.print("Escolha um número inteiro diferente do anterior: ");
        b = teclado.nextInt();
        
        System.out.print("Escolha um número inteiro deferente dos anteriores: ");
        c = teclado.nextInt();
        
        if(a > b && b > c){
            System.out.printf("Ordem decrescente: %d %d %d", a, b, c);
            }
        else if(a > c && c < b){
            System.out.printf("Ordem decrescente: %d %d %d", a, c, b);
            }
        else if(b > a && a > c){
            System.out.printf("Ordem decrescente: %d %d %d", b, a, c);
            }
        else if(b > c && c > a){
            System.out.printf("Ordem decrescente: %d %d %d", b, c, a);
            }
        else if(c > a && a > b){
            System.out.printf("Ordem decrescente: %d %d %d", c, a, b);
            }
        else if(c > b && b > a){
            System.out.printf("Ordem decrescente: %d %d %d", c, b, a);
            }
        else{
            System.out.print("Os números escolhidos não são diferentes.");
        }
        teclado.close();
    }
}