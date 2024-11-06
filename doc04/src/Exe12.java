/*
Escreva um algoritmo que leia o número de identificação, 
as 3 notas obtidas por um aluno nas 3 verificações 
e a média dos exercícios que fazem parte da avaliação, 
e calcule a média de aproveitamento, usando a fórmula:
MA := (nota1 + nota 2 * 2 + nota 3 * 3 + ME)/7
A atribuição dos conceitos obedece a tabela abaixo. 
O algoritmo deve escrever o número do aluno, suas notas, 
a média dos exercícios, a média de aproveitamento, o conceito correspondente 
e a mensagem 'Aprovado' se o conceito for A, B ou C, e 'Reprovado' se o conceito for D ou E.
Média de aproveitamento Conceito:
>= 90 A
>= 75 e < 90 B
>= 60 e < 75 C
>= 40 e < 60 D
< 40 E
*/
import java.util.Scanner;
public class Exe12{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        int numeroIdentificacao = 0, nota1 = 0, nota2 = 0, nota3 = 0, mediaExercicio = 0, mediaAproveitamento = 0;
        String conceito = "", mensagem = "";

        System.out.print("Informe o número de identificação: ");
        numeroIdentificacao = teclado.nextInt();
        System.out.print("Informe a nota 1: ");
        nota1 = teclado.nextInt();
        System.out.print("Informe a nota 2: ");
        nota2 = teclado.nextInt();
        System.out.print("Informe a nota 3: ");
        nota3 = teclado.nextInt();
        
        mediaExercicio = (nota1 + nota2 + nota3) / 3;
        mediaAproveitamento = (nota1 + nota2 * 2 + nota3 * 3 + mediaExercicio) / 7;

        if(mediaAproveitamento >= 90){
            conceito = "A";
            mensagem = "Aprovado";
        }
        else if(mediaAproveitamento >= 75 && mediaAproveitamento < 90){
            conceito = "B";
            mensagem = "Aprovado";
        }
        else if(mediaAproveitamento >= 60 && mediaAproveitamento < 75){
            conceito = "C";
            mensagem = "Aprovado";
        }
        else if(mediaAproveitamento >= 40 && mediaAproveitamento < 90){
            conceito = "D";
            mensagem = "Reprovado";
        }
        else if(mediaAproveitamento < 40){
            conceito = "E";
            mensagem = "Reprovado";
        }

        System.out.printf("Número do aluno: %d\n", numeroIdentificacao);
        System.out.printf("Nota 1: %d\n", nota1);
        System.out.printf("Nota 2: %d\n", nota2);
        System.out.printf("Nota 3: %d\n", nota3);
        System.out.printf("Média dos exercícios: %d\n", mediaExercicio);
        System.out.printf("Média de aproveitamento: %d\n", mediaAproveitamento);
        System.out.printf("Conceito: %s\n", conceito);
        System.out.printf("Aluno %s\n", mensagem);
        
        teclado.close();
    }
}