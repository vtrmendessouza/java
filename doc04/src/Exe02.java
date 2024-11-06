/*
Faça um algoritmo que leia o nome, o sexo e o estado civil de uma pessoa. 
Caso o sexo seja “F” e o estado civil seja “CASADA”, solicitar o tempo de casada em anos.
*/
import java.util.Scanner;
public class Exe02{
	public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
       
        // Lê o nome, sexo e estado civil
        System.out.print("Digite o nome: ");
        String nome = teclado.nextLine();
        System.out.print("Digite o sexo (M/F): ");
        String sexo = teclado.nextLine().toUpperCase();
        System.out.print("Digite o estado civil (SOLTEIRO/CASADO): ");
        String estadoCivil = teclado.nextLine().toUpperCase();
        
        // Verifica se o sexo é "F" e o estado civil é "CASADO"
        if(sexo.equals("F") && estadoCivil.equals("CASADO")) {
            System.out.print("Digite o tempo de casada em anos: ");
            int tempoCasado = teclado.nextInt();
            System.out.print(nome + " está casada há " + tempoCasado + " anos.");
        }
        else{
            System.out.print(nome + " não é uma mulher casada.");
        }
        teclado.close();
    }
}