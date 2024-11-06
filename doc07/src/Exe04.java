/*
04: Faça um algoritmo utilizando a estrutura "while" que fique perguntando para o usuário 
se ele deseja continuar o laço respondendo s ou n. 
Laço deve continuar quando o usuário responde s.
*/

import java.util.Scanner;

public class Exe04 {
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        char resposta = 's';
        
        while(resposta == 's'){
            System.out.print("Deseja continuar? s/n: ");
            resposta = teclado.next().charAt(0);
        }
        teclado.close();
    }
}