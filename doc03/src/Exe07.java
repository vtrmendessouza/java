/*
Exercício 07: 
Faça um programa que lê as duas notas parciais 
obtidas por um aluno numa disciplina ao longo de um semestre, 
e calcule a sua média apresentando na tela qual o conceito obtido. 
A atribuição de conceitos obedece à tabela abaixo:
Média de Aproveitamento
Intervalo dos Valores	Conceito
Entre 9 e 10	A
Entre 7.5 e 9	B
Entre 6 e 7.5	C
Entre 4 e 6	    D
Entre 0 e 4	    E
*/
import java.util.Scanner;
public class Exe07{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        float nota1 = 0, nota2 = 0, media = 0;

        System.out.print("Informe a primeira nota valendo 10 pontos: ");
        nota1 = teclado.nextFloat();
        teclado.nextLine();
        System.out.print("Informe a segunda nota valendo dez pontos: ");
        nota2 = teclado.nextFloat();
        teclado.nextLine();

        media = (nota1 + nota2) / 2;

        if(media >= 9 && media <= 10){
            System.out.print("Conceito A");
            teclado.close();
            System.exit(0);
        }
        else if(media >= 7.5 && media < 9){
            System.out.print("Conceito B");
            teclado.close();
            System.exit(0);
        }
        else if(media >= 6 && media < 7.5){
            System.out.print("Conceito C");
            teclado.close();
            System.exit(0);
        }
        else if(media >= 4 && media < 6){
            System.out.print("Conceito D");
            teclado.close();
            System.exit(0);
        }
        else{
            System.out.print("Conceito E");
            teclado.close();
            System.exit(0);
        }
    }
}