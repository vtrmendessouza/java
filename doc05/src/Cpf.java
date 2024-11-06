/*
pdv = d1 * 10 + d2 * 9 + d3 * 8 + d4 * 7 + d5 * 6 + d6 * 5 + d7 * 4 + d8 * 3 + d9 * 2;
sdv = d1 * 11 + d2 * 10 + d3 * 9 + d4 * 8 + d5 * 7 + d6 * 6 + d7 * 5 + d8 * 4 + d9 * 3 + pdv * 2;
*/
import java.util.Scanner;
public class Cpf {
    public static void main (String[] args) throws Exception {
        Scanner teclado;
        String cpf;
        int pdv = 0, sdv = 0, q = 0;
        boolean valido = true;

        //leitura de string cpf
        teclado = new Scanner(System.in);
        System.out.print("Informe o CPF: ");
        cpf = teclado.nextLine();

        //eliminar caracteres invalidos
        StringBuilder cpfFiltrado = new StringBuilder();
        for (int i = 0; i < cpf.length(); i++) {
            if (Character.isDigit(cpf.charAt(i))) {
                cpfFiltrado.append(cpf.charAt(i));
            }
        }

        //converter string em array int
        int[] cpfInt = new int [cpfFiltrado.length()];
        for(int i = 0; i < cpfFiltrado.length(); i++){
            cpfInt[i] = Character.getNumericValue(cpfFiltrado.charAt(i));
        }

        //fase de multiplicacao pdv
        int[] pdvVet = new int [cpfFiltrado.length() - 2];
        q = 10;
        for(int i = 0; i < pdvVet.length; i++){
            pdvVet[i] = cpfInt[i] * q;
            q--;
        }
        
        //fase de soma pdv
        for(int i = 0; i < pdvVet.length; i++){
            pdv += pdvVet[i];
        }
        
        //gerar pdv
        if(pdv % 11 < 2) {
            pdv = 0;
        }
        else{
            pdv = 11 - (pdv % 11);
        }
        
        //fase de multiplicação sdv
        int[] sdvVet = new int [cpfFiltrado.length() - 2];
        q = 11;
        for(int i = 0; i < sdvVet.length; i++) {
            sdvVet[i] = cpfInt[i] * q;
            q--;
        }
        
        //fase de soma sdv
        for(int i = 0; i < sdvVet.length; i++){
            sdv += sdvVet[i];
        }
        
        //gerar sdv
        sdv = sdv + pdv * 2;
        if(sdv % 11 < 2){
            sdv = 0;
        }
        else{
            sdv = 11 - (sdv % 11);
        }
        
        //verificar se todos os digitos sao iguais
        q = cpfInt[0];
        for(int i = 0; i < cpfInt.length; i++){
            if(q == cpfInt[i]){
                valido = false;
            }
            else{
                valido = true;
            }
        }
        
        //verificar a quantidade de digitos
        if(cpfInt.length != 11){
            valido = false;
        }
        
        //comparar de verificadores
        if(pdv != cpfInt[cpfFiltrado.length() - 2] || sdv != cpfInt[cpfFiltrado.length() - 1]){
            valido = false;
        }
        
        //imprimir cpf digitado
        System.out.print("CPF informado: ");
        for(int i = 0; i < cpfInt.length; i++){
        System.out.printf("%d ", cpfInt[i]);
        }
        
        //imprimir verificadores obtidos
        System.out.printf("\nVerificadores obtidos: %d %d\n", pdv, sdv);
        
        //imprimir validade do cpf
        if(valido){
            System.out.print("CPF válido.\n");
        }
        else{
            System.out.print("CPF inválido.\n");
        }
        teclado.close();
    }
}