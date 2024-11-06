import java.util.Scanner;
public class Exe04{
	public static void main(String[] args){
        /*
        Radar de Velocidade:
        Desenvolva um algoritmo que leia a velocidade de um veículo e uma velocidade máxima.
        Exiba uma mensagem informando se o veículo excedeu 7% da velocidade máxima.
        */
        Scanner teclado = new Scanner(System.in);
        int velocidadeVeiculo = 0, velocidadeMaxima = 0, velocidadeExcedente = 0;
        
        System.out.print("informe a velocidade do veiculo: ");
        velocidadeVeiculo = teclado.nextInt();

        System.out.print("informe a velocidade maxima: ");
        velocidadeMaxima = teclado.nextInt();

        velocidadeExcedente = velocidadeVeiculo / velocidadeMaxima;

        if(velocidadeExcedente > 1.07){
            System.out.print("excedente maior que 7%");
        }
        else{
            System.out.print("exedente menor que 7%");
        }
        teclado.close();
    }
}