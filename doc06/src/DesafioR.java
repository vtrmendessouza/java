/*
Para extrair o dia, o mês e o ano, estude os métodos da classe String abaixo:
https://www.w3schools.com/java/ref_string_substring.asp
https://www.w3schools.com/java/ref_string_trim.asp 
https://www.w3schools.com/java/ref_string_indexof.asp
https://www.w3schools.com/java/ref_string_lastindexof.asp
*/
package desafio;
import java.util.Scanner;
public class DesafioR {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String data;
        int dia, mes, ano;
        boolean anoEhBissexto;

        System.out.print("Digite o data: ");
        data = teclado.nextLine();
        
        dia = //faça a chamada da funcao;
        mes = //faça a chamada da funcao;
        ano = //faça a chamada da funcao;
       
        anoEhBissexto = (ano % 4 == 0) && ((ano % 100 != 0) || (ano % 400 == 0));

        // se o dia for 29 e o mes for fevereiro e o ano nao é bissexto
        if (dia == 29 && mes == 2 && !anoEhBissexto) {
            System.out.print("A data é invalida pois o ano nao e bissexto.");
            // o dia e maior que 31
        } else if (dia > 31) {
            System.out.print("A data é invalida pois nao existe dia maior que 31.");
            // quando dia e 31 e (o mes for fevereiro ou abril ou junho ou setembro ou
            // novembro)
        } else if (dia == 31 && (mes == 2 || mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
            System.out.print("A data é invalida pois nao existe 31 no mes + " + mes);
            // quando o dia for 30 e o mes fevereiro
        } else if (dia == 30 && mes == 2) {
            System.out.print("A data é invalida pois nao existe 30 de fevereiro.");
            // se o mes for maior que 12
        } else if (mes < 1 || mes > 12) {
            System.out.print("A data é invalida pois os meses deve ser entre 1 e 12");
        } else {
            System.out.print("A data é valida!");
        }

        teclado.close();
    }

    static int obterDia(String data){
        int dia;

        return dia;
    }

    static int obterMes(String data){
        int mes;
        
        return mes;
    }

    static int obterAno(String data){
        int ano;
        
        return ano;
    }
}