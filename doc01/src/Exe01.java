import java.util.Scanner;
public class Exe01{
	public static void main(String[] args){
        /*
        Verificador de Idade para Habilitação:
        Escreva um programa que peça ao usuário sua idade
        e verifique se ele pode obter uma carteira de habilitação.
        As regras são: a idade mínima é 18 anos.
        Exiba uma mensagem indicando se o usuário pode ou não obter a habilitação.
        */
        Scanner teclado = new Scanner(System.in);
        int idade = 0;
        
        System.out.print("informe a idade: ");
        idade = teclado.nextInt();

        if(idade >= 18){
            System.out.print("apto\n");
        }
        else{
            System.out.print("inapito\n");
        }
        teclado.close();
    }
}