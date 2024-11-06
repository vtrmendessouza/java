/*
05: Faça um algoritmo utilizando a estrutura "do while" que fique perguntando para o usuário 
se ele deseja continuar o laço respondendo s ou n. 
Laço deve continuar quando o usuário responde s.
*/

import java.util.Scanner;

public class Exe05 {
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        char resposta = 's';
        
        do{
            System.out.print("Deseja continuar? s/n: ");
            resposta = teclado.next().charAt(0);
        }while(resposta == 's');
        teclado.close();
    }
}