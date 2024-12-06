/*
Reescreva o código abaixo para a partir de uma data informada pelo usuário, 
seja possível extrair o dia o mês e o ano para que o restante do código seja executado.
Lembre-se que o seu código precisa prever a possibilidade do usuário informar uma data no seguinte formato:
01/02/2024
01/2/2024
1/02/2024
1/2/2024
01-02-2024
01-2-2024
1-02-2024
1-2-2024
*/
import java.util.Scanner;
public class Exe07 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        String data = "";
        int dia, mes, ano;
        boolean anoEhBissexto;

        System.out.print("Digite a data: ");
        data = teclado.nextLine();
        
        dia = obterDia(data);
        mes = obterMes(data);
        ano = obterAno(data);
       
        anoEhBissexto = (ano % 4 == 0) && ((ano % 100 != 0) || (ano % 400 == 0));

        // se o dia for 29 e o mes for fevereiro e o ano nao é bissexto
        if (dia == 29 && mes == 2 && !anoEhBissexto) {
            System.out.println("A data é invalida pois o ano nao e bissexto.");
            // o dia e maior que 31
        } else if (dia > 31) {
            System.out.println("A data é invalida pois nao existe dia maior que 31.");
            // quando dia e 31 e (o mes for fevereiro ou abril ou junho ou setembro ou
            // novembro)
        } else if (dia == 31 && (mes == 2 || mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
            System.out.println("A data é invalida pois nao existe 31 no mes + " + mes);
            // quando o dia for 30 e o mes fevereiro
        } else if (dia == 30 && mes == 2) {
            System.out.println("A data é invalida pois nao existe 30 de fevereiro.");
            // se o mes for maior que 12
        } else if (mes < 1 || mes > 12) {
            System.out.println("A data é invalida pois os meses deve ser entre 1 e 12");
        } else {
            System.out.println("A data é valida!");
        }
        teclado.close();
    }
    static int obterDia(String data){
        int dia = 0, sinal = 0;
        
        for(int i = 0; i < data.length(); i++){
            if(data.charAt(i) == '/' || data.charAt(i) == '-'){
                sinal = i;
                break;
            }
        }
        dia = Integer.parseInt(data.substring(0, sinal));
        return dia;
    }
    static int obterMes(String data){
        int mes = 0, sinal1 = 0, sinal2 = 0;
        
        for(int i = 0; i < data.length(); i++){
            if(data.charAt(i) == '/' || data.charAt(i) == '-'){
                sinal1 = i;
                break;
            }
        }
        for(int i = sinal1 + 1; i < data.length(); i++){
            if(data.charAt(i) == '/' || data.charAt(i) == '-'){
                sinal2 = i;
                break;
            }
        }
        mes = Integer.parseInt(data.substring(sinal1 + 1, sinal2));
        return mes;
    }
    static int obterAno(String data){
        int ano = 0, sinal1 = 0, sinal2 = 0;
        
        for(int i = 0; i < data.length(); i++){
            if(data.charAt(i) == '/' || data.charAt(i) == '-'){
                sinal1 = i;
                break;
            }
        }
        for(int i = sinal1 + 1; i < data.length(); i++){
            if(data.charAt(i) == '/' || data.charAt(i) == '-'){
                sinal2 = i;
                break;
            }
        }
        ano = Integer.parseInt(data.substring(sinal2 + 1));
        return ano;
    }
}