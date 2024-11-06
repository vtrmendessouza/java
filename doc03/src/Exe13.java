/*
Exercício 13: 
Faça um Programa que solicite um dia, um mês e um ano e determine se estes números forma uma data válida. 
Não utilize nenhuma biblioteca adicional do Java para isto. 
Faça apenas utilizando estrutruas de decisão. Pesquise como identificar se um ano é um número bisexto.
Exemplo 01:
Digite o dia: 29
Digite o mês: 02
Digite o ano: 2016
A data 29/02/2016 é válida 
Exemplo 02:
Digite o dia: 29
Digite o mês: 02
Digite o ano: 2017
A data 29/02/2017 é inválida 
Exemplo 03:
Digite o dia: 31
Digite o mês: 04
Digite o ano: 2017
A data 31/04/2017 é inválida
Exemplo 04:
Digite o dia: 30
Digite o mês: 04
Digite o ano: 2017
A data 30/04/2017 é válida
*/
import java.util.Scanner;
public class Exe13{
	public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        int dia = 0, mes = 0, ano = 0;

        System.out.print("Digite o dia: ");
        dia = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Digite o mês: ");
        mes = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Digite o ano: ");
        ano = teclado.nextInt();
        teclado.nextLine();

        if(ano < 1){
            System.out.printf("A data %d/%d/%d é inválida.", dia, mes, ano);
            teclado.close();
            System.exit(0);
        }
        else if(mes < 1 || mes > 12){
            System.out.printf("A data %d/%d/%d é inválida.", dia, mes, ano);
            teclado.close();
            System.exit(0);
        }
        else if(dia < 1 || dia > 31){
            System.out.printf("A data %d/%d/%d é inválida.", dia, mes, ano);
            teclado.close();
            System.exit(0);
        }
        else if(dia > 30 && mes == 4){
            System.out.printf("A data %d/%d/%d é inválida.", dia, mes, ano);
            teclado.close();
            System.exit(0);
        }
        else if(dia > 30 && mes == 6){
            System.out.printf("A data %d/%d/%d é inválida.", dia, mes, ano);
            teclado.close();
            System.exit(0);
        }
        else if(dia > 30 && mes == 9){
            System.out.printf("A data %d/%d/%d é inválida.", dia, mes, ano);
            teclado.close();
            System.exit(0);
        }
        else if(dia > 30 && mes == 10){
            System.out.printf("A data %d/%d/%d é inválida.", dia, mes, ano);
            teclado.close();
            System.exit(0);
        }
        else if(dia > 28 && mes == 2 && ano % 4 != 0){
            System.out.printf("A data %d/%d/%d é inválida.", dia, mes, ano);
            teclado.close();
            System.exit(0);
        }
        else{
            System.out.printf("A data %d/%d/%d é válida.", dia, mes, ano);
            teclado.close();
            System.exit(0);
        }
    }
}