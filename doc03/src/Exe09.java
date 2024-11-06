/*
Exercício 09: 
Faça um programa que faça 5 perguntas para uma pessoa sobre um crime. 
As perguntas são:
"Telefonou para a vítima?"
"Esteve no local do crime?"
"Mora perto da vítima?"
"Devia para a vítima?"
"Já trabalhou com a vítima?"
O usuário deve responder em cada pergunta: 1 para sim ou 0 para não. 
O programa deve no final emitir uma classificação sobre a participação da pessoa no crime. 
Se a pessoa responder sim em 2 questões ela deve ser classificada como "Suspeita", 
entre 3 e 4 como "Cúmplice" e 5 como "Assassino". Caso contrário, ele será classificado como "Inocente".
*/
import java.util.Scanner;
public class Exe09{
	public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        int respostaUsuario = 0, respostaSoma = 0;

        do{    
            System.out.print("Responda 1 para SIM ou 0 para NÃO:\n");
            System.out.print("Telefonou para a vítima? ");
            respostaUsuario = teclado.nextInt();
            teclado.nextLine();
            if(respostaUsuario != 1 && respostaUsuario != 0){
                System.out.print("Opção inválida.\n");
            }
            if(respostaUsuario == 1){
                respostaSoma++;
            }
        }
        while(respostaUsuario != 1 && respostaUsuario != 0);
        do{
            System.out.print("Responda 1 para SIM ou 0 para NÃO:\n");
            System.out.print("Esteve no local do crime? ");
            respostaUsuario = teclado.nextInt();
            teclado.nextLine();
            if(respostaUsuario != 1 && respostaUsuario != 0){
                System.out.print("Opção inválida.\n");
            }
            if(respostaUsuario == 1){
                respostaSoma++;
            }
        }
        while(respostaUsuario != 1 && respostaUsuario != 0);
        do{
            System.out.print("Responda 1 para SIM ou 0 para NÃO:\n");
            System.out.print("Mora perto da vítima? ");
            respostaUsuario = teclado.nextInt();
            teclado.nextLine();
            if(respostaUsuario != 1 && respostaUsuario != 0){
                System.out.print("Opção inválida.\n");
            }
            if(respostaUsuario == 1){
                respostaSoma++;
            }
        }
        while(respostaUsuario != 1 && respostaUsuario != 0);
        do{
            System.out.print("Responda 1 para SIM ou 0 para NÃO:\n");
            System.out.print("Devia para a vítima? ");
            respostaUsuario = teclado.nextInt();
            teclado.nextLine();
            if(respostaUsuario != 1 && respostaUsuario != 0){
                System.out.print("Opção inválida.\n");
            }
            if(respostaUsuario == 1){
                respostaSoma++;
            }
        }
        while(respostaUsuario != 1 && respostaUsuario != 0);
        do{
            System.out.print("Responda 1 para SIM ou 0 para NÃO:\n");
            System.out.print("Devia para a vítima? ");
            respostaUsuario = teclado.nextInt();
            teclado.nextLine();
            if(respostaUsuario != 1 && respostaUsuario != 0){
                System.out.print("Opção inválida.\n");
            }
            if(respostaUsuario == 1){
                respostaSoma++;
            }
        }
        while(respostaUsuario != 1 && respostaUsuario != 0);

        if(respostaSoma == 2){
            System.out.println("Suspeito.");
        }
        else if(respostaSoma >= 3 && respostaSoma <= 4){
            System.out.print("Cúmplice.");
        }
        else if(respostaSoma == 5){
            System.out.print("Culpado.");
        }
        else{
            System.out.print("Inocente.");
        }
        teclado.close();
        System.exit(0);
    }
}