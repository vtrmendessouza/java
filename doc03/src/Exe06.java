/*
Exercício 06: 
Faça um Programa que leia um número e exiba o dia correspondente da semana, conforme esta regra: 
(1 - Domingo, 2 - Segunda, 3 - Terça, 4 - Quarta, 5 - Quinta, 6 - Sexta e 7 - Sábado). 
Se o usuário digitar outro valor deve aparecer valor inválido.
*/
import java.util.Scanner;
public class Exe06{
	public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        int dia = 0;

        System.out.print("Informe o dia: ");
        dia = teclado.nextInt();
        teclado.nextLine();
        
        if(dia == 1){
            System.out.print("Domingo");
            teclado.close();
            System.exit(0);
        }
        else if(dia == 2){
            System.out.print("Segunda");
            teclado.close();
            System.exit(0);
        }
        else if(dia == 3){
            System.out.print("Terça");
            teclado.close();
            System.exit(0);
        }
        else if(dia == 4){
            System.out.print("Quarta");
            teclado.close();
            System.exit(0);
        }
        else if(dia == 5){
            System.out.print("Quinta");
            teclado.close();
            System.exit(0);
        }
        else if(dia == 6){
            System.out.print("Sexta");
            teclado.close();
            System.exit(0);
        }
        else if(dia == 7){
            System.out.print("Sábado");
            teclado.close();
            System.exit(0);
        }
        else{
            System.out.print("Valor inválido");
            teclado.close();
            System.exit(0);
        }
    }
}