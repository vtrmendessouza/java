import java.util.Scanner;
public class Exe07 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int dia, mes, ano;
        boolean anoNaoEhBissexto;

        System.out.print("Digite o dia do mes: ");
        dia = teclado.nextInt();

        System.out.print("Digite o mes do ano: ");
        mes = teclado.nextInt();
        
        System.out.print("Digite o ano: ");
        ano = teclado.nextInt();

        anoNaoEhBissexto = ((ano % 4) != 0);
         // corrigir (ano % 4 == 0) && ((ano % 100 != 0) || (ano % 400 == 0))

        // se o dia for 29 e o mes for fevereiro e o ano nao é bissexto
        if (dia == 29 && mes == 2 && anoNaoEhBissexto ) {
            System.out.print("A data é invalida pois o ano nao e bissexto.");
        //o dia e maior que 31
        } else if (dia > 31) { 
            System.out.print("A data é invalida pois nao existe dia maior que 31.");
        // quando dia e 31 e (o mes for fevereiro ou abril ou junho ou setembro ou novembro)
        } else if (dia == 31 && (mes == 2 || mes == 4 || mes == 6 || mes == 9 || mes == 11 )){
            System.out.print("A data é invalida pois nao existe 31 no mes + " + mes);
        // quando o dia for 30 e o mes fevereiro
        } else if (dia == 30 && mes == 2){
            System.out.print("A data é invalida pois nao existe 30 de fevereiro.");
        // se o mes for maior que 12
        } else if (mes < 1 || mes > 12){
            System.out.print("A data é invalida pois os meses deve ser entre 1 e 12");
        } else {
            System.out.print("A data é valida: ");
        }

        teclado.close();
    }
} 